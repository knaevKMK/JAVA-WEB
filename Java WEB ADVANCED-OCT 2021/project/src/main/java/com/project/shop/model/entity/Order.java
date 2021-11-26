package com.project.shop.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity {
    private int quantity;
    private Listing listing;
    private Account buyer;
    private Feedback feedback;
    private BigDecimal price;
    private boolean isCompleted;
    private String deliveryAddress;

    public Order() {
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public Order setCompleted(boolean completed) {
        isCompleted = completed;
        return this;
    }

    @Column(columnDefinition = "TEXT", nullable = false)
    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public Order setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
        return this;
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

    @ManyToOne
    public Listing getListing() {
        return listing;
    }

    public Order setListing(Listing listing) {
        this.listing = listing;
        return this;
    }

    @ManyToOne(cascade = {CascadeType.DETACH}, fetch = FetchType.EAGER)
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
