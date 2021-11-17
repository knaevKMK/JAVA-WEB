package com.project.shop.model.binding;

import java.util.UUID;

public class ListingCreateModel {
    private UUID id;
    private String title;
    private String description;
    private String imageUrl;

    private CategoryBindingModel category;
    private ConditionBindingModel condition;
    //  private Account seller;
    private SellingFormatBindingModel sellingFormat;
    private DeliveryBindingModel  deliveryDomestic;
    private DeliveryBindingModel  deliveryInternational;

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

    public CategoryBindingModel getCategory() {
        return category;
    }

    public ListingCreateModel setCategory(CategoryBindingModel category) {
        this.category = category;
        return this;
    }

    public ConditionBindingModel getCondition() {
        return condition;
    }

    public ListingCreateModel setCondition(ConditionBindingModel condition) {
        this.condition = condition;
        return this;
    }

    public SellingFormatBindingModel getSellingFormat() {
        return sellingFormat;
    }

    public ListingCreateModel setSellingFormat(SellingFormatBindingModel sellingFormat) {
        this.sellingFormat = sellingFormat;
        return this;
    }

    public DeliveryBindingModel getDeliveryDomestic() {
        return deliveryDomestic;
    }

    public ListingCreateModel setDeliveryDomestic(DeliveryBindingModel deliveryDomestic) {
        this.deliveryDomestic = deliveryDomestic;
        return this;
    }

    public DeliveryBindingModel getDeliveryInternational() {
        return deliveryInternational;
    }

    public ListingCreateModel setDeliveryInternational(DeliveryBindingModel deliveryInternational) {
        this.deliveryInternational = deliveryInternational;
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
