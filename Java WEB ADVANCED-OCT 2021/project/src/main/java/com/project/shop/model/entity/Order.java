package com.project.shop.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order extends  Item{
    private int quantity;
    private List<Listing> listings;
    private Account buyer;
    private Feedback feedback;
    private BigDecimal price;


    public Order() {
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Order setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public Order setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
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
