package com.project.shop.model.view;

import java.math.BigDecimal;
import java.util.UUID;

public class OrderViewModel {
    private UUID id;
    private UUID listingId;
    private String listingTitle;
    private String listingImageUrl;
    private int quantity;
    private BigDecimal price;
    private boolean isCompleted;
    private String deliveryAddress;

    public OrderViewModel() {
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public OrderViewModel setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
        return this;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public OrderViewModel setCompleted(boolean completed) {
        isCompleted = completed;
        return this;
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

    public String getListingTitle() {
        return listingTitle;
    }

    public OrderViewModel setListingTitle(String listingTitle) {
        this.listingTitle = listingTitle;
        return this;
    }

    public String getListingImageUrl() {
        return listingImageUrl;
    }

    public OrderViewModel setListingImageUrl(String listingImageUrl) {
        this.listingImageUrl = listingImageUrl;
        return this;
    }
}
