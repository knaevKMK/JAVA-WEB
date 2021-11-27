package com.project.shop.model.view;

import java.time.LocalDateTime;

public class MsgViewModel {
    private String sender;
    private String recipient;
    private LocalDateTime createOn;
    private ListingInListViewModel listing;
    private String text;

    public MsgViewModel() {
    }

    public String getSender() {
        return sender;
    }

    public MsgViewModel setSender(String sender) {
        this.sender = sender;
        return this;
    }

    public String getRecipient() {
        return recipient;
    }

    public MsgViewModel setRecipient(String recipient) {
        this.recipient = recipient;
        return this;
    }

    public LocalDateTime getCreateOn() {
        return createOn;
    }

    public MsgViewModel setCreateOn(LocalDateTime createOn) {
        this.createOn = createOn;
        return this;
    }

    public ListingInListViewModel getListing() {
        return listing;
    }

    public MsgViewModel setListing(ListingInListViewModel listing) {
        this.listing = listing;
        return this;
    }

    public String getText() {
        return text;
    }

    public MsgViewModel setText(String text) {
        this.text = text;
        return this;
    }
}
