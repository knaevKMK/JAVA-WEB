package com.project.shop.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "messages")
public class Message extends BaseEntity {
    private Account recipient;
    private Listing listing;
    private String text;

    public Message() {
    }

    @ManyToOne
    public Account getRecipient() {
        return recipient;
    }

    public Message setRecipient(Account recipient) {
        this.recipient = recipient;
        return this;
    }

    @ManyToOne
    public Listing getListing() {
        return listing;
    }

    public Message setListing(Listing listing) {
        this.listing = listing;
        return this;
    }

    @Column(nullable = false, columnDefinition = "TEXT")
    public String getText() {
        return text;
    }

    public Message setText(String text) {
        this.text = text;
        return this;
    }
}
