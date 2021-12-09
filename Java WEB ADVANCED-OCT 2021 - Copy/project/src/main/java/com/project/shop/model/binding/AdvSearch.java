package com.project.shop.model.binding;

import java.math.BigDecimal;

public class AdvSearch {

    public String title;
    public Byte titleSort;
    public String description;
    public String category;
    public String condition;
    public String seller;
    public String sellingFormat;
    public BigDecimal price;
    public Byte priceSort;
    public Byte priceArrow;
    public Byte timeSort;

    public AdvSearch() {
    }

    public Byte getTitleSort() {
        return titleSort;
    }

    public AdvSearch setTitleSort(Byte titleSort) {
        this.titleSort = titleSort;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public AdvSearch setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AdvSearch setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public AdvSearch setCategory(String category) {
        this.category = category;
        return this;
    }

    public String getCondition() {
        return condition;
    }

    public AdvSearch setCondition(String condition) {
        this.condition = condition;
        return this;
    }

    public String getSeller() {
        return seller;
    }

    public AdvSearch setSeller(String seller) {
        this.seller = seller;
        return this;
    }

    public String getSellingFormat() {
        return sellingFormat;
    }

    public AdvSearch setSellingFormat(String sellingFormat) {
        this.sellingFormat = sellingFormat;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public AdvSearch setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Byte getPriceSort() {
        return priceSort;
    }

    public AdvSearch setPriceSort(Byte priceSort) {
        this.priceSort = priceSort;
        return this;
    }

    public Byte getPriceArrow() {
        return priceArrow;
    }

    public AdvSearch setPriceArrow(Byte priceArrow) {
        this.priceArrow = priceArrow;
        return this;
    }

    public Byte getTimeSort() {
        return timeSort;
    }

    public AdvSearch setTimeSort(Byte timeSort) {
        this.timeSort = timeSort;
        return this;
    }
}
