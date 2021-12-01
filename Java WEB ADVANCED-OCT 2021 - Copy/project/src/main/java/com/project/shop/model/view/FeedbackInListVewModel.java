package com.project.shop.model.view;

import java.util.UUID;

public class FeedbackInListVewModel {
    private UUID id;
    private String request;
    private String  sender;
    private String response;
    private String recipient;
    private String listingTitle;
    private boolean isPositive;


    public FeedbackInListVewModel() {
    }

    public String getSender() {
        return sender;
    }

    public FeedbackInListVewModel setSender(String sender) {
        this.sender = sender;
        return this;
    }

    public String getResponse() {
        return response;
    }

    public FeedbackInListVewModel setResponse(String response) {
        this.response = response;
        return this;
    }

    public String getRecipient() {
        return recipient;
    }

    public FeedbackInListVewModel setRecipient(String recipient) {
        this.recipient = recipient;
        return this;
    }

    public boolean isPositive() {
        return isPositive;
    }

    public FeedbackInListVewModel setPositive(boolean positive) {
        isPositive = positive;
        return this;
    }

    public UUID getId() {
        return id;
    }

    public FeedbackInListVewModel setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getRequest() {
        return request;
    }

    public FeedbackInListVewModel setRequest(String request) {
        this.request = request;
        return this;
    }



    public String getListingTitle() {
        return listingTitle;
    }

    public FeedbackInListVewModel setListingTitle(String listingTitle) {
        this.listingTitle = listingTitle;
        return this;
    }
}
