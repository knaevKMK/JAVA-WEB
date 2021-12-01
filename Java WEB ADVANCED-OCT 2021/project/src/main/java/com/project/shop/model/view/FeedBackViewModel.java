package com.project.shop.model.view;

import com.project.shop.model.entity.Order;

import java.util.UUID;

public class FeedBackViewModel {
    private UUID id;
    private String request;
    private String  sender;
    private String response;
    private String recipient;
    private String listingTitle;
    private boolean isPositive;

    public FeedBackViewModel() {
    }

    public boolean isPositive() {
        return isPositive;
    }

    public FeedBackViewModel setPositive(boolean positive) {
        isPositive = positive;
        return this;
    }

    public String getRecipient() {
        return recipient;
    }

    public FeedBackViewModel setRecipient(String recipient) {
        this.recipient = recipient;
        return this;
    }

    public String getSender() {
        return sender;
    }

    public FeedBackViewModel setSender(String sender) {
        this.sender = sender;
        return this;
    }

    public UUID getId() {
        return id;
    }

    public FeedBackViewModel setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getRequest() {
        return request;
    }

    public FeedBackViewModel setRequest(String request) {
        this.request = request;
        return this;
    }

    public String getResponse() {
        return response;
    }

    public FeedBackViewModel setResponse(String response) {
        this.response = response;
        return this;
    }

    public String getListingTitle() {
        return listingTitle;
    }

    public FeedBackViewModel setListingTitle(String listingTitle) {
        this.listingTitle = listingTitle;
        return this;
    }
}
