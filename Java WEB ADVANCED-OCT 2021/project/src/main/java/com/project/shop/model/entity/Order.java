package com.project.shop.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order extends  Item{
    private List<Listing> listings;
    private Account Buyer;
    private Feedback feedback;

    public Order() {
    }
@OneToMany
    public List<Listing> getListings() {
        return listings;
    }

    public Order setListings(List<Listing> listings) {
        this.listings = listings;
        return this;
    }
@ManyToOne
public Account getBuyer() {
        return Buyer;
    }

    public Order setBuyer(Account buyer) {
        Buyer = buyer;
        return this;
    }
@OneToOne
    public Feedback getFeedback() {
        return feedback;
    }

    public Order setFeedback(Feedback feedback) {
        this.feedback = feedback;
        return this;
    }
}
