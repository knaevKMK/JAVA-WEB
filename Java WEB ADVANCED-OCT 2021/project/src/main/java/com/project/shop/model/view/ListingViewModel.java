package com.project.shop.model.view;

import java.util.UUID;

public class ListingViewModel {
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

    public ListingViewModel() {
    }

    public UUID getId() {
        return id;
    }

    public ListingViewModel setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public ListingViewModel setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ListingViewModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ListingViewModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getItemCategoryItem() {
        return itemCategoryItem;
    }

    public ListingViewModel setItemCategoryItem(String itemCategoryItem) {
        this.itemCategoryItem = itemCategoryItem;
        return this;
    }

    public String getItemCondition() {
        return itemCondition;
    }

    public ListingViewModel setItemCondition(String itemCondition) {
        this.itemCondition = itemCondition;
        return this;
    }

    public String getSellingFormat() {
        return sellingFormat;
    }

    public ListingViewModel setSellingFormat(String sellingFormat) {
        this.sellingFormat = sellingFormat;
        return this;
    }

    public String getDeliveryOptions() {
        return deliveryOptions;
    }

    public ListingViewModel setDeliveryOptions(String deliveryOptions) {
        this.deliveryOptions = deliveryOptions;
        return this;
    }

    public String getPayment() {
        return payment;
    }

    public ListingViewModel setPayment(String payment) {
        this.payment = payment;
        return this;
    }
}
