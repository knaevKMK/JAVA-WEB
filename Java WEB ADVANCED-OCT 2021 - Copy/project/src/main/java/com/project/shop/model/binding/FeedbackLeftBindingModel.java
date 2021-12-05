package com.project.shop.model.binding;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.UUID;


public class FeedbackLeftBindingModel {
    private UUID orderId;
    private String ownerListingUsername;
    private String request;
    private boolean positive;

    public FeedbackLeftBindingModel() {
    }
@NotNull
    public UUID getOrderId() {
        return orderId;
    }

    public FeedbackLeftBindingModel setOrderId(UUID orderId) {
        this.orderId = orderId;
        return this;
    }

    public String getOwnerListingUsername() {
        return ownerListingUsername;
    }

    public FeedbackLeftBindingModel setOwnerListingUsername(String ownerListingUsername) {
        this.ownerListingUsername = ownerListingUsername;
        return this;
    }
@NotNull
@NotBlank
@NotEmpty
    public String getRequest() {
        return request;
    }

    public FeedbackLeftBindingModel setRequest(String request) {
        this.request = request;
        return this;
    }
@NotNull
    public boolean isPositive() {
        return positive;
    }

    public FeedbackLeftBindingModel setPositive(boolean positive) {
        this.positive = positive;
        return this;
    }
}
