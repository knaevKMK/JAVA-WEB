package com.project.shop.model.service;

import java.util.UUID;

public class MsgServiceModel {

    private String recipientUsername;
    private UUID listingId;
    private String text;

    public MsgServiceModel() {
    }

    public String getRecipientUsername() {
        return recipientUsername;
    }

    public MsgServiceModel setRecipientUsername(String recipientUsername) {
        this.recipientUsername = recipientUsername;
        return this;
    }

    public UUID getListingId() {
        return listingId;
    }

    public MsgServiceModel setListingId(UUID listingId) {
        this.listingId = listingId;
        return this;
    }

    public String getText() {
        return text;
    }

    public MsgServiceModel setText(String text) {
        this.text = text;
        return this;
    }
}
