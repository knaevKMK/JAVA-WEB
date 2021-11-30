package com.project.shop.service.impl;

import com.project.shop.model.binding.FeedbackBindingModel;
import com.project.shop.model.binding.FeedbackLeftBindingModel;
import com.project.shop.model.entity.Feedback;
import com.project.shop.model.entity.Order;
import com.project.shop.model.view.FeedBackViewModel;
import com.project.shop.repository.FeedBackRepository;
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
public class FeedBackServiceImpl implements FeedBackService {
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
    public List<Feedback> getSentFeedBackByOrder(UUID orderId) {
        return feedBackRepository.findAllByOrder_Id(orderId);
    }

    @Override
    public List<Feedback> getSentFeedBackByUsername(String username) {

        return feedBackRepository.findAllByOrder_Buyer_Username(username);
    }

    @Override
    public List<Feedback> getReceivedFeedBackByUsername(String username) {
        return feedBackRepository.findAllByOrder_Listing_CreatFrom(username);
    }

    @Override
    public String sendFeedBack(FeedbackLeftBindingModel model, String username) {
        Feedback feedback = modelMapper.map(model, Feedback.class);
        Order order = orderService.getBuyId(model.getOrderId())
                .orElseThrow(() -> new NullPointerException("Order does not exist"));
        feedback.setOrder(order);
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
    public List<FeedBackViewModel> getAll(Authentication authentication, String query, int page, int limit) {
        List<Feedback> result= new ArrayList<>();
        String[] tokens = query.split("_");
        switch (tokens[0]) {
            case "sent":
                result= getSentFeedBackByUsername(tokens[1]) ; break;
            case "receiver":
                result= getReceivedFeedBackByUsername(tokens[1]);break;
            case "id":
                result= getSentFeedBackByOrder(UUID.fromString(tokens[1]));break;
        }
        return result.stream().map(f->modelMapper.map(f,FeedBackViewModel.class)).collect(Collectors.toList());
    }



    @Override
    public List<Feedback> getPositiveFeedbacks(String username) {
        return feedBackRepository.findAllByPositiveIsTrueAndOrder_Listing_CreateFrom(username);

    }

    @Override
    public int getCountPositiveFeedbacksCount(String username) {
        return this.getPositiveFeedbacks(username).size();
    }
}
