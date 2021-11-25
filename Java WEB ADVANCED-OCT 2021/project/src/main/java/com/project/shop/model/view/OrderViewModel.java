package com.project.shop.model.view;

import java.math.BigDecimal;
import java.util.UUID;

public class OrderViewModel {
    private UUID id;
    private UUID listingId;
    private int quantity;
    private BigDecimal price;

    public OrderViewModel() {
    }

    public UUID getId() {
        return id;
    }

    public OrderViewModel setId(UUID id) {
        this.id = id;
        return this;
    }

    public UUID getListingId() {
        return listingId;
    }

    public OrderViewModel setListingId(UUID listingId) {
        this.listingId = listingId;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public OrderViewModel setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OrderViewModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
}
