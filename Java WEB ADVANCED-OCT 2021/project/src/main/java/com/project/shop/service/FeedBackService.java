package com.project.shop.service;

import com.project.shop.model.binding.FeedbackBindingModel;
import com.project.shop.model.binding.FeedbackLeftBindingModel;
import com.project.shop.model.entity.Feedback;
import com.project.shop.model.view.FeedBackViewModel;
import org.springframework.security.core.Authentication;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FeedBackService {
    Optional<Feedback> getById(UUID id);

    List<Feedback> getSentFeedBackByOrder(UUID listingId);

    List<Feedback> getSentFeedBackByUsername(String username);

    List<Feedback> getReceivedFeedBackByUsername(String username);

    String sendFeedBack(FeedbackLeftBindingModel model, String username);

    List<FeedBackViewModel> getAll(Authentication authentication, String query, int page, int limit);


    String responseFeedBack(UUID id, FeedbackBindingModel model, String username);

    List<Feedback> getPositiveFeedbacks(String username);
    int getCountPositiveFeedbacksCount(String username);
}
