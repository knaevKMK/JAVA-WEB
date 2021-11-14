package com.project.shop.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order extends  Item{
    private List<Listing> listings;
    private Account buyer;
    private Feedback feedback;

    public Order() {
    }
@OneToMany(mappedBy = "order")
    public List<Listing> getListings() {
        return listings;
    }

    public Order setListings(List<Listing> listings) {
        this.listings = listings;
        return this;
    }
@ManyToOne(cascade={CascadeType.ALL})
@JoinColumn(name = "buyer_id")
public Account getBuyer() {
        return buyer;
    }

    public Order setBuyer(Account buyer) {
        this.buyer = buyer;
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
