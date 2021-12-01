package com.project.shop.model.binding;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class OrderBindingModel {
    private UUID id;
    private UUID listingId;
    private int quantity;
    private BigDecimal price;
    private String buyerUsername;
    private String deliveryAddress;

    public OrderBindingModel() {
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public OrderBindingModel setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
        return this;
    }

    public UUID getId() {
        return id;
    }

    public OrderBindingModel setId(UUID id) {
        this.id = id;
        return this;
    }

    public UUID getListingId() {
        return listingId;
    }

    public OrderBindingModel setListingId(UUID listingId) {
        this.listingId = listingId;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public OrderBindingModel setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OrderBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getBuyerUsername() {
        return buyerUsername;
    }

    public OrderBindingModel setBuyerUsername(String buyerUsername) {
        this.buyerUsername = buyerUsername;
        return this;
    }
}
