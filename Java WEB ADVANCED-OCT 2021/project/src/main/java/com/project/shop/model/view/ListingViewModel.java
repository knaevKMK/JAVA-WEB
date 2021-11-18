package com.project.shop.model.view;

import java.util.UUID;

public class ListingViewModel {
    private UUID id;
    private String title;
    private String description;
    private String imageUrl;
    private CategoryViewModel category;
    private ConditionViewModel condition;
    //  private Account seller;
//todo make dto and service model next 3 fields
    private SellingVewModel sellingFormat;
    private DeliveryViewModel deliveryDomestic;
    private DeliveryViewModel  deliveryInternational;

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

    public CategoryViewModel getCategory() {
        return category;
    }

    public ListingViewModel setCategory(CategoryViewModel category) {
        this.category = category;
        return this;
    }

    public ConditionViewModel getCondition() {
        return condition;
    }

    public ListingViewModel setCondition(ConditionViewModel condition) {
        this.condition = condition;
        return this;
    }

    public SellingVewModel getSellingFormat() {
        return sellingFormat;
    }

    public ListingViewModel setSellingFormat(SellingVewModel sellingFormat) {
        this.sellingFormat = sellingFormat;
        return this;
    }

    public DeliveryViewModel getDeliveryDomestic() {
        return deliveryDomestic;
    }

    public ListingViewModel setDeliveryDomestic(DeliveryViewModel deliveryDomestic) {
        this.deliveryDomestic = deliveryDomestic;
        return this;
    }

    public String getPayment() {
        return payment;
    }

    public ListingViewModel setPayment(String payment) {
        this.payment = payment;
        return this;
    }

    public DeliveryViewModel getDeliveryInternational() {
        return deliveryInternational;
    }

    public ListingViewModel setDeliveryInternational(DeliveryViewModel deliveryInternational) {
        this.deliveryInternational = deliveryInternational;
        return this;
    }
}
