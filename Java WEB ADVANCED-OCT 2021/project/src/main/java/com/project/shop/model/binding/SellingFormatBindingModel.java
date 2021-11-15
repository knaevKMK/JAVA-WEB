package com.project.shop.model.binding;

import com.project.shop.model.enums.SellingFormatEnum;

import java.math.BigDecimal;

public class SellingFormatBindingModel {
    private SellingFormatEnum sellingFormatTitle;
    private int daysDuration;
    private BigDecimal price;
    private int quantity;

    public SellingFormatBindingModel() {
    }

    public SellingFormatEnum getSellingFormatTitle() {
        return sellingFormatTitle;
    }

    public SellingFormatBindingModel setSellingFormatTitle(SellingFormatEnum sellingFormatTitle) {
        this.sellingFormatTitle = sellingFormatTitle;
        return this;
    }

    public int getDaysDuration() {
        return daysDuration;
    }

    public SellingFormatBindingModel setDaysDuration(int daysDuration) {
        this.daysDuration = daysDuration;
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
