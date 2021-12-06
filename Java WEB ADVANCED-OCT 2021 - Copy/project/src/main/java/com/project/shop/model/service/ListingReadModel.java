package com.project.shop.model.service;

import com.project.shop.model.binding.CategoryBindingModel;
import com.project.shop.model.binding.DeliveryBindingModel;
import com.project.shop.model.binding.SellingFormatBindingModel;


public class ListingReadModel {
    private String title;
    private String description;
    private String imageUrl;

    private CategoryBindingModel category;
    private String condition;
    private String usernameCreator;
    private SellingFormatBindingModel sellingFormat;
    private DeliveryBindingModel deliveryDomestic;
    private DeliveryBindingModel deliveryInternational;

    private String paymentTitle;

    public ListingReadModel() {
    }

    public String getTitle() {
        return title;
    }

    public ListingReadModel setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ListingReadModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ListingReadModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public CategoryBindingModel getCategory() {
        return category;
    }

    public ListingReadModel setCategory(CategoryBindingModel category) {
        this.category = category;
        return this;
    }

    public String getCondition() {
        return condition;
    }

    public ListingReadModel setCondition(String condition) {
        this.condition = condition;
        return this;
    }

    public String getUsernameCreator() {
        return usernameCreator;
    }

    public ListingReadModel setUsernameCreator(String usernameCreator) {
        this.usernameCreator = usernameCreator;
        return this;
    }

    public SellingFormatBindingModel getSellingFormat() {
        return sellingFormat;
    }

    public ListingReadModel setSellingFormat(SellingFormatBindingModel sellingFormat) {
        this.sellingFormat = sellingFormat;
        return this;
    }

    public DeliveryBindingModel getDeliveryDomestic() {
        return deliveryDomestic;
    }

    public ListingReadModel setDeliveryDomestic(DeliveryBindingModel deliveryDomestic) {
        this.deliveryDomestic = deliveryDomestic;
        return this;
    }

    public DeliveryBindingModel getDeliveryInternational() {
        return deliveryInternational;
    }

    public ListingReadModel setDeliveryInternational(DeliveryBindingModel deliveryInternational) {
        this.deliveryInternational = deliveryInternational;
        return this;
    }

    public String getPaymentTitle() {
        return paymentTitle;
    }

    public ListingReadModel setPaymentTitle(String paymentTitle) {
        this.paymentTitle = paymentTitle;
        return this;
    }
}
