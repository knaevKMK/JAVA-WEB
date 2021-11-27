package com.project.shop.model.view;

import java.time.LocalDateTime;

public class MsgListViewModel {
    private String sender;
    private String recipient;
    private LocalDateTime createOn;
    private String title;

    public MsgListViewModel() {
    }

    public String getSender() {
        return sender;
    }

    public MsgListViewModel setSender(String sender) {
        this.sender = sender;
        return this;
    }

    public String getRecipient() {
        return recipient;
    }

    public MsgListViewModel setRecipient(String recipient) {
        this.recipient = recipient;
        return this;
    }

    public LocalDateTime getCreateOn() {
        return createOn;
    }

    public MsgListViewModel setCreateOn(LocalDateTime createOn) {
        this.createOn = createOn;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public MsgListViewModel setTitle(String title) {
        this.title = title;
        return this;
    }
}
