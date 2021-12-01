package com.project.shop.model.binding;


import java.util.UUID;

public class MsgBindingModel {
    private String recipientUsername;
    private UUID listingId;
    private String text;

    public MsgBindingModel() {
    }

    public String getRecipientUsername() {
        return recipientUsername;
    }

    public MsgBindingModel setRecipientUsername(String recipientUsername) {
        this.recipientUsername = recipientUsername;
        return this;
    }

    public UUID getListingId() {
        return listingId;
    }

    public MsgBindingModel setListingId(UUID listingId) {
        this.listingId = listingId;
        return this;
    }

    public String getText() {
        return text;
    }

    public MsgBindingModel setText(String text) {
        this.text = text;
        return this;
    }
}
