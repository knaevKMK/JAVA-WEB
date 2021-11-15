package com.project.shop.model.binding;

import java.util.UUID;

public class ListingCreateModel {
    private UUID id;
    private String title;
    private String description;
    private String imageUrl;

    private CategoryBindingModel itemCategoryItem;
    private ConditionBindingModel itemCondition;
    //  private Account seller;
    private SellingFormatBindingModel sellingFormat;
    private DeliveryBindingModel  deliveryOptions;

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

    public CategoryBindingModel getItemCategoryItem() {
        return itemCategoryItem;
    }

    public ListingCreateModel setItemCategoryItem(CategoryBindingModel itemCategoryItem) {
        this.itemCategoryItem = itemCategoryItem;
        return this;
    }

    public ConditionBindingModel getItemCondition() {
        return itemCondition;
    }

    public ListingCreateModel setItemCondition(ConditionBindingModel itemCondition) {
        this.itemCondition = itemCondition;
        return this;
    }

    public SellingFormatBindingModel getSellingFormat() {
        return sellingFormat;
    }

    public ListingCreateModel setSellingFormat(SellingFormatBindingModel sellingFormat) {
        this.sellingFormat = sellingFormat;
        return this;
    }

    public DeliveryBindingModel getDeliveryOptions() {
        return deliveryOptions;
    }

    public ListingCreateModel setDeliveryOptions(DeliveryBindingModel deliveryOptions) {
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
