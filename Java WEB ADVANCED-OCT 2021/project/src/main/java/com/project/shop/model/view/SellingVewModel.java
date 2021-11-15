package com.project.shop.model.view;

import com.project.shop.model.enums.SellingFormatEnum;

import java.math.BigDecimal;

public class SellingVewModel {
    private SellingFormatEnum sellingFormatTitle;
    private int daysDuration;
    private BigDecimal price;
    private int quantity;

    public SellingVewModel() {
    }

    public SellingFormatEnum getSellingFormatTitle() {
        return sellingFormatTitle;
    }

    public SellingVewModel setSellingFormatTitle(SellingFormatEnum sellingFormatTitle) {
        this.sellingFormatTitle = sellingFormatTitle;
        return this;
    }

    public int getDaysDuration() {
        return daysDuration;
    }

    public SellingVewModel setDaysDuration(int daysDuration) {
        this.daysDuration = daysDuration;
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
