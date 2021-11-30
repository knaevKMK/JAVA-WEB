package com.project.shop.model.binding;

import com.project.shop.model.entity.Order;

import java.util.UUID;

public class FeedbackBindingModel {

    private UUID id;
    private String response;

    public FeedbackBindingModel() {
    }

    public UUID getId() {
        return id;
    }

    public FeedbackBindingModel setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getResponse() {
        return response;
    }

    public FeedbackBindingModel setResponse(String response) {
        this.response = response;
        return this;
    }

    public UUID getOrderId() {
        return id;
    }

    public FeedbackBindingModel setOrderId(UUID orderId) {
        this.id = orderId;
        return this;
    }
}
