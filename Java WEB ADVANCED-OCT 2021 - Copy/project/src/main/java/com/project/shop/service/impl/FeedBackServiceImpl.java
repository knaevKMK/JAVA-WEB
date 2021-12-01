package com.project.shop.service.impl;

import com.project.shop.identityArea.models.entity.UserEntity;
import com.project.shop.model.binding.FeedbackBindingModel;
import com.project.shop.model.binding.FeedbackLeftBindingModel;
import com.project.shop.model.entity.Feedback;
import com.project.shop.model.entity.Order;
import com.project.shop.model.view.FeedBackViewModel;
import com.project.shop.model.view.FeedbackInListVewModel;
import com.project.shop.repository.FeedBackRepository;
import com.project.shop.service.BaseService;
import com.project.shop.service.FeedBackService;
import com.project.shop.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class FeedBackServiceImpl extends BaseServiceImpl<Feedback> implements FeedBackService {
    private final FeedBackRepository feedBackRepository;
    private final ModelMapper modelMapper;
    private final OrderService orderService;

    public FeedBackServiceImpl(FeedBackRepository feedBackRepository, ModelMapper modelMapper, OrderService orderService) {
        this.feedBackRepository = feedBackRepository;
        this.modelMapper = modelMapper;
        this.orderService = orderService;
    }

    @Override
    public Optional<Feedback> getById(UUID id) {
        return feedBackRepository.findById(id);
    }

    @Override
    public List<FeedbackInListVewModel> getSentFeedBackByOrder(UUID orderId) {
        return feedBackRepository.findAllByOrder_Id(orderId)
                .stream().map(e->modelMapper.map(e,FeedbackInListVewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<FeedbackInListVewModel> getSentFeedBackByUsername(String username) {

        return feedBackRepository.findAllByOrder_Buyer_Username(username).stream().map(e->modelMapper.map(e,FeedbackInListVewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<FeedbackInListVewModel> getReceivedFeedBackByUsername(String username) {
        return feedBackRepository.findAllByOrder_Listing_CreatFrom(username)
                .stream().map(e->modelMapper.map(e,FeedbackInListVewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public String sendFeedBack(FeedbackLeftBindingModel model, String username) {
        Feedback feedback = modelMapper.map(model, Feedback.class);
        Order order = orderService.getBuyId(model.getOrderId())
                .orElseThrow(() -> new NullPointerException("Order does not exist"));
        feedback.setId(null);
        feedback.setOrder(order);
        feedback = onCreate(feedback, username);
        feedBackRepository.saveAndFlush(feedback);
        return "FeeBack was sent";
    }
    @Override
    public String responseFeedBack(UUID id,FeedbackBindingModel model, String username) {
        Feedback feedback = this.getById(model.getOrderId())
                .orElseThrow(() -> new NullPointerException("Something went wrong"));
        Order order = orderService.getBuyId(model.getOrderId())
                .orElseThrow(() -> new NullPointerException("Order does not exist"));
        if (!order.getListing().getCreateFrom().equals(username)) {
            return "You are not authorized to response to this feedback";
        }
        feedback.setResponse(model.getResponse());
        feedBackRepository.saveAndFlush(feedback);
        return "FeeBack was sent";
    }
    @Override
    public List<FeedbackInListVewModel> getAll(Authentication authentication, String query, int page, int limit) {
//        UserEntity principal = (UserEntity)authentication.getPrincipal();
        String[] tokens = query.split("_");
        switch (tokens[0]) {
            case "sent":
                return getSentFeedBackByUsername(tokens[1]) ;
            case "receiver":
                return getReceivedFeedBackByUsername(tokens[1]);
            case "positive":
                return getPositiveFeedbacks(tokens[1]);
            case "negative":
                return getNegativeFeedbacks(tokens[1]);
            case "id":
                return getSentFeedBackByOrder(UUID.fromString(tokens[1]));
        }
        return new ArrayList<FeedbackInListVewModel>();
    }



    @Override
    public List<FeedbackInListVewModel> getPositiveFeedbacks(String username) {
        return feedBackRepository
                .findAllByPositiveAndOrder_Listing_CreateFromOrOrder_Buyer_Username(true,username,username)
                .stream().map(f->modelMapper.map(f,FeedbackInListVewModel.class))
                .collect(Collectors.toList());


    }

    @Override
    public List<FeedbackInListVewModel> getNegativeFeedbacks(String username) {
        return feedBackRepository.
        findAllByPositiveAndOrder_Listing_CreateFromOrOrder_Buyer_Username(false,username,username)
                .stream().map(f->modelMapper.map(f,FeedbackInListVewModel.class))
                .collect(Collectors.toList());


    }

    @Override
    public int getCountPositiveFeedbacksCount(String username) {
        return this.getPositiveFeedbacks(username).size();
    }
}
