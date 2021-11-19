package com.project.shop.model.binding;

import com.project.shop.model.enums.SellingFormatEnum;

import java.math.BigDecimal;

public class SellingFormatBindingModel {
    private SellingFormatEnum title;
    private int duration;
    private BigDecimal price;
    private int quantity;

    public SellingFormatBindingModel() {
    }

    public SellingFormatEnum getTitle() {
        return title;
    }

    public SellingFormatBindingModel setTitle(SellingFormatEnum title) {
        this.title = title;
        return this;
    }

    public int getDuration() {
        return duration;
    }

    public SellingFormatBindingModel setDuration(int duration) {
        this.duration = duration;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public SellingFormatBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public SellingFormatBindingModel setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }
}
