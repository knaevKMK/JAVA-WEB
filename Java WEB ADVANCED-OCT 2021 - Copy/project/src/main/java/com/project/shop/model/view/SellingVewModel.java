package com.project.shop.model.view;

import com.project.shop.model.enums.SellingFormatEnum;

import java.math.BigDecimal;

public class SellingVewModel {
    private SellingFormatEnum title;
    private int duration;

    private BigDecimal price;
    private int quantity;

    public SellingVewModel() {
    }

    public SellingFormatEnum getTitle() {
        return title;
    }

    public SellingVewModel setTitle(SellingFormatEnum title) {
        this.title = title;
        return this;
    }

    public int getDuration() {
        return duration;
    }

    public SellingVewModel setDuration(int duration) {
        this.duration = duration;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public SellingVewModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public SellingVewModel setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }
}
