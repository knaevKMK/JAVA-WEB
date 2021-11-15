package com.project.shop.model.entity;

import com.project.shop.model.enums.SellingFormatEnum;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "selling_formats")
public class SellingFormat extends BaseEntity {
    private SellingFormatEnum sellingFormatTitle;
    private int daysDuration;
    private BigDecimal price;
    private int quantity;

    public SellingFormat() {
    }

    public int getDaysDuration() {
        return daysDuration;
    }

    public SellingFormat setDaysDuration(int daysDuration) {
        this.daysDuration = daysDuration;
        return this;
    }

    public SellingFormatEnum getSellingFormatTitle() {
        return sellingFormatTitle;
    }

    public SellingFormat setSellingFormatTitle(SellingFormatEnum sellingFormatTitle) {
        this.sellingFormatTitle = sellingFormatTitle;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public SellingFormat setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public SellingFormat setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

}
