package com.project.shop.model.view;

import java.math.BigDecimal;
import java.util.UUID;

public class ListingInListViewModel {
    private UUID id;
    private String imageUrl;
    private String title;
    private BigDecimal price;

    public ListingInListViewModel() {
    }

    public UUID getId() {
        return id;
    }

    public ListingInListViewModel setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ListingInListViewModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public ListingInListViewModel setTitle(String title) {
        this.title = title;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ListingInListViewModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
}
