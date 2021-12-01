package com.project.shop.model.view;

import java.util.UUID;

public class FeedbackInListVewModel {
    private UUID id;
    private String request;
    private UUID listingId;
    private String listingTitle;
    private String leftFrom;

    public FeedbackInListVewModel() {
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

    public UUID getListingId() {
        return listingId;
    }

    public FeedbackInListVewModel setListingId(UUID listingId) {
        this.listingId = listingId;
        return this;
    }

    public String getListingTitle() {
        return listingTitle;
    }

    public FeedbackInListVewModel setListingTitle(String listingTitle) {
        this.listingTitle = listingTitle;
        return this;
    }

    public String getLeftFrom() {
        return leftFrom;
    }

    public FeedbackInListVewModel setLeftFrom(String leftFrom) {
        this.leftFrom = leftFrom;
        return this;
    }
}
