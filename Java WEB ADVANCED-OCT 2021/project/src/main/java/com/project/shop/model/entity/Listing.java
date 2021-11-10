package com.project.shop.model.entity;


import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "listings")
public class Listing extends Item {
    private String imageUrl;
    private CategoryItem itemCategoryItem;
    private ConditionItem itemCondition;
    private Account seller;

    private SellingFormat sellingFormat;
    private DeliveryOptions deliveryOptions;


    private PaymentMethod payment;

    public Listing() {
    }
@ManyToOne
    public Account getSeller() {
        return seller;
    }

    public Listing setSeller(Account seller) {
        this.seller = seller;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Listing setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
@ManyToOne
    public CategoryItem getItemCategoryItem() {
        return itemCategoryItem;
    }

    public Listing setItemCategoryItem(CategoryItem itemCategoryItem) {
        this.itemCategoryItem = itemCategoryItem;
        return this;
    }
@ManyToOne
    public ConditionItem getItemCondition() {
        return itemCondition;
    }

    public Listing setItemCondition(ConditionItem itemCondition) {
        this.itemCondition = itemCondition;
        return this;
    }
@ManyToOne
    public SellingFormat getSellingFormat() {
        return sellingFormat;
    }

    public Listing setSellingFormat(SellingFormat sellingFormat) {
        this.sellingFormat = sellingFormat;
        return this;
    }
@ManyToOne
    public DeliveryOptions getDeliveryOptions() {
        return deliveryOptions;
    }

    public Listing setDeliveryOptions(DeliveryOptions deliveryOptions) {
        this.deliveryOptions = deliveryOptions;
        return this;
    }
@ManyToOne
    public PaymentMethod getPayment() {
        return payment;
    }

    public Listing setPayment(PaymentMethod payment) {
        this.payment = payment;
        return this;
    }
}
