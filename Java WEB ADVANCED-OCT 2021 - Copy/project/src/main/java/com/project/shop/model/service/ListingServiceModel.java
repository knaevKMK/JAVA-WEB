package com.project.shop.model.service;

import com.project.shop.model.binding.CategoryBindingModel;
import com.project.shop.model.binding.ConditionBindingModel;
import com.project.shop.model.binding.DeliveryBindingModel;
import com.project.shop.model.binding.SellingFormatBindingModel;

import java.util.UUID;

public class ListingServiceModel {
    private UUID id;
    private String title;
    private String description;
    private String imageUrl;

    private CategoryBindingModel category;
    private ConditionBindingModel condition;
    private String usernameCreator;
    private SellingFormatBindingModel sellingFormat;
    private DeliveryBindingModel deliveryDomestic;
    private DeliveryBindingModel deliveryInternational;

    private UUID payment;

    public ListingServiceModel() {
    }

    public UUID getId() {
        return id;
    }

    public ListingServiceModel setId(UUID id) {
        this.id = id;
        return this;
    }



    public String getUsernameCreator() {
        return usernameCreator;
    }

    public ListingServiceModel setUsernameCreator(String usernameCreator) {
        this.usernameCreator = usernameCreator;
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



    public SellingFormatBindingModel getSellingFormat() {
        return sellingFormat;
    }

    public ListingServiceModel setSellingFormat(SellingFormatBindingModel sellingFormat) {
        this.sellingFormat = sellingFormat;
        return this;
    }

    public UUID getPayment() {
        return payment;
    }

    public ListingServiceModel setPayment(UUID payment) {
        this.payment = payment;
        return this;
    }

    public CategoryBindingModel getCategory() {
        return category;
    }

    public ListingServiceModel setCategory(CategoryBindingModel category) {
        this.category = category;
        return this;
    }

    public ConditionBindingModel getCondition() {
        return condition;
    }

    public ListingServiceModel setCondition(ConditionBindingModel condition) {
        this.condition = condition;
        return this;
    }

    public DeliveryBindingModel getDeliveryDomestic() {
        return deliveryDomestic;
    }

    public ListingServiceModel setDeliveryDomestic(DeliveryBindingModel deliveryDomestic) {
        this.deliveryDomestic = deliveryDomestic;
        return this;
    }

    public DeliveryBindingModel getDeliveryInternational() {
        return deliveryInternational;
    }

    public ListingServiceModel setDeliveryInternational(DeliveryBindingModel deliveryInternational) {
        this.deliveryInternational = deliveryInternational;
        return this;
    }
}
