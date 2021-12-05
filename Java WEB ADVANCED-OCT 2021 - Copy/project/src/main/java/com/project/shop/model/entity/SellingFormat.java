package com.project.shop.model.entity;

import com.project.shop.model.enums.SellingFormatEnum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Entity
@Table(name = "selling_formats")
public class SellingFormat extends BaseEntity {
    private SellingFormatEnum title;
    private int duration;
    private BigDecimal price;
    private int quantity;

    public SellingFormat() {
    }

    public int getDuration() {
        return duration;
    }

    public SellingFormat setDuration(int daysDuration) {
        this.duration = daysDuration;
        return this;
    }

    public SellingFormatEnum getTitle() {
        return title;
    }

    public SellingFormat setTitle(SellingFormatEnum sellingFormatTitle) {
        this.title = sellingFormatTitle;
        return this;
    }

    @Positive
    public BigDecimal getPrice() {
        return price;
    }

    public SellingFormat setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    @Positive
    public int getQuantity() {
        return quantity;
    }

    public SellingFormat setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

}
