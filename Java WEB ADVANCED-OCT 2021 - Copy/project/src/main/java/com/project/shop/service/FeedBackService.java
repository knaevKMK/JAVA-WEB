package com.project.shop.service;

import com.project.shop.model.binding.FeedbackBindingModel;
import com.project.shop.model.binding.FeedbackLeftBindingModel;
import com.project.shop.model.entity.Feedback;
import com.project.shop.model.view.FeedBackViewModel;
import com.project.shop.model.view.FeedbackInListVewModel;
import org.springframework.security.core.Authentication;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FeedBackService {
    Optional<Feedback> getById(UUID id);

    List<FeedbackInListVewModel> getSentFeedBackByOrder(UUID listingId);

    List<FeedbackInListVewModel> getSentFeedBackByUsername(String username);

    List<FeedbackInListVewModel> getReceivedFeedBackByUsername(String username);

    String sendFeedBack(FeedbackLeftBindingModel model, String username);

    List<FeedbackInListVewModel> getAll(Authentication authentication, String query, int page, int limit);


    String responseFeedBack(UUID id, FeedbackBindingModel model, String username);

    List<FeedbackInListVewModel> getPositiveFeedbacks(String username);
    List<FeedbackInListVewModel> getNegativeFeedbacks(String username);
    int getCountPositiveFeedbacksCount(String username);
}
