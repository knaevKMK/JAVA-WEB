package com.project.shop.model.service;

import com.project.shop.model.binding.CategoryBindingModel;
import com.project.shop.model.binding.ConditionBindingModel;
import com.project.shop.model.binding.DeliveryBindingModel;
import com.project.shop.model.binding.SellingFormatBindingModel;
import com.project.shop.model.entity.*;

import java.util.UUID;

public class ListingServiceModel {
    private UUID id;
    private String title;
    private String description;
    private String imageUrl;

    private CategoryBindingModel itemCategoryItem;
    private ConditionBindingModel itemCondition;
    //  private Account seller;
    private SellingFormatBindingModel sellingFormat;
    private DeliveryBindingModel deliveryOptions;

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

    public CategoryBindingModel getItemCategoryItem() {
        return itemCategoryItem;
    }

    public ListingServiceModel setItemCategoryItem(CategoryBindingModel itemCategoryItem) {
        this.itemCategoryItem = itemCategoryItem;
        return this;
    }

    public ConditionBindingModel getItemCondition() {
        return itemCondition;
    }

    public ListingServiceModel setItemCondition(ConditionBindingModel itemCondition) {
        this.itemCondition = itemCondition;
        return this;
    }

    public SellingFormatBindingModel getSellingFormat() {
        return sellingFormat;
    }

    public ListingServiceModel setSellingFormat(SellingFormatBindingModel sellingFormat) {
        this.sellingFormat = sellingFormat;
        return this;
    }

    public DeliveryBindingModel getDeliveryOptions() {
        return deliveryOptions;
    }

    public ListingServiceModel setDeliveryOptions(DeliveryBindingModel deliveryOptions) {
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
