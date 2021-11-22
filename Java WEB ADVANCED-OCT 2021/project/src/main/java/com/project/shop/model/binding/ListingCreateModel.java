package com.project.shop.model.binding;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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
@NotNull
@NotEmpty
@Length(min = 7,max = 70)
    public String getTitle() {
        return title;
    }

    public ListingCreateModel setTitle(String title) {
        this.title = title;
        return this;
    }
    @NotNull
    @NotEmpty
    @Length(min = 20,max = 1000)
    public String getDescription() {
        return description;
    }

    public ListingCreateModel setDescription(String description) {
        this.description = description;
        return this;
    }
    @NotNull
    @NotEmpty
    public String getImageUrl() {
        return imageUrl;
    }

    public ListingCreateModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
@NotNull
    public CategoryBindingModel getCategory() {
        return category;
    }

    public ListingCreateModel setCategory(CategoryBindingModel category) {
        this.category = category;
        return this;
    }
@NotNull
    public ConditionBindingModel getCondition() {
        return condition;
    }

    public ListingCreateModel setCondition(ConditionBindingModel condition) {
        this.condition = condition;
        return this;
    }
@NotNull
    public SellingFormatBindingModel getSellingFormat() {
        return sellingFormat;
    }

    public ListingCreateModel setSellingFormat(SellingFormatBindingModel sellingFormat) {
        this.sellingFormat = sellingFormat;
        return this;
    }
@NotNull
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
@NotNull
    public String getPayment() {
        return payment;
    }

    public ListingCreateModel setPayment(String payment) {
        this.payment = payment;
        return this;
    }
}
