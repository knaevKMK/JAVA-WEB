package com.project.shop.model.binding;

import java.util.UUID;

public class ListingCreateModel {
    private UUID id;
    private String title;
    private String description;
    private String imageUrl;
    private String itemCategoryItem;
    private String itemCondition;
    //  private Account seller;
//todo make dto and service model next 3 fields
    private String sellingFormat;
    private String  deliveryOptions;

    private String payment;

    public ListingCreateModel() {
    }

    public UUID getId() {
        return id;
    }

    public ListingCreateModel setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public ListingCreateModel setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ListingCreateModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ListingCreateModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getItemCategoryItem() {
        return itemCategoryItem;
    }

    public ListingCreateModel setItemCategoryItem(String itemCategoryItem) {
        this.itemCategoryItem = itemCategoryItem;
        return this;
    }

    public String getItemCondition() {
        return itemCondition;
    }

    public ListingCreateModel setItemCondition(String itemCondition) {
        this.itemCondition = itemCondition;
        return this;
    }

    public String getSellingFormat() {
        return sellingFormat;
    }

    public ListingCreateModel setSellingFormat(String sellingFormat) {
        this.sellingFormat = sellingFormat;
        return this;
    }

    public String getDeliveryOptions() {
        return deliveryOptions;
    }

    public ListingCreateModel setDeliveryOptions(String deliveryOptions) {
        this.deliveryOptions = deliveryOptions;
        return this;
    }

    public String getPayment() {
        return payment;
    }

    public ListingCreateModel setPayment(String payment) {
        this.payment = payment;
        return this;
    }
}
