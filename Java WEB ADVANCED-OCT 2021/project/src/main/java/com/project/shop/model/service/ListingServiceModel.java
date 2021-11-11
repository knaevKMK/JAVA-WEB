package com.project.shop.model.service;

import com.project.shop.model.entity.*;

import java.util.UUID;

public class ListingServiceModel {
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
    public ListingServiceModel() {
    }

    public UUID getId() {
        return id;
    }

    public ListingServiceModel setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public ListingServiceModel setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ListingServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ListingServiceModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getItemCategoryItem() {
        return itemCategoryItem;
    }

    public ListingServiceModel setItemCategoryItem(String itemCategoryItem) {
        this.itemCategoryItem = itemCategoryItem;
        return this;
    }

    public String getItemCondition() {
        return itemCondition;
    }

    public ListingServiceModel setItemCondition(String itemCondition) {
        this.itemCondition = itemCondition;
        return this;
    }

    public String getSellingFormat() {
        return sellingFormat;
    }

    public ListingServiceModel setSellingFormat(String sellingFormat) {
        this.sellingFormat = sellingFormat;
        return this;
    }

    public String getDeliveryOptions() {
        return deliveryOptions;
    }

    public ListingServiceModel setDeliveryOptions(String deliveryOptions) {
        this.deliveryOptions = deliveryOptions;
        return this;
    }

    public String getPayment() {
        return payment;
    }

    public ListingServiceModel setPayment(String payment) {
        this.payment = payment;
        return this;
    }
}
