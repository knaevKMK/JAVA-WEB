package com.project.shop.model.entity;



import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "listings")
public class Listing extends Item {

    private String imageUrl;
    private CategoryItem category;
    private ConditionItem condition;
    private Account seller;

    private Set<Account> watchers=new HashSet<>();
    private List<Order> orders=new ArrayList<>();
    private SellingFormat sellingFormat;
    private DeliveryOptions deliveryDomestic;
    private DeliveryOptions deliveryInternational;
    private Payment payment;

    public Listing() {
    }


    @OneToMany(mappedBy = "listing",fetch = FetchType.EAGER)
    public List<Order> getOrders() {
        return orders;
    }

    public Listing setOrders(List<Order> orders) {
        this.orders = orders;
        return this;
    }

    @ManyToMany(mappedBy = "watchList",cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Account.class)
    public Set<Account> getWatchers() {
        return watchers;
    }

    public Listing setWatchers(Set<Account> watchers) {
        this.watchers = watchers;
        return this;
    }

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "seller_id")
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

    @ManyToOne(optional = true,fetch = FetchType.LAZY)
    @NotFound(action= NotFoundAction.IGNORE)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    public CategoryItem getCategory() {
        return category;
    }

    public Listing setCategory(CategoryItem itemCategoryItem) {
        this.category = itemCategoryItem;
        return this;
    }

    @ManyToOne(optional = true,fetch = FetchType.LAZY)
    @NotFound(action= NotFoundAction.IGNORE)
    @JoinColumn(name = "condition_id", referencedColumnName = "id")
    public ConditionItem getCondition() {
        return condition;
    }

    public Listing setCondition(ConditionItem itemCondition) {
        this.condition = itemCondition;
        return this;
    }

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "selling_format_id")
    public SellingFormat getSellingFormat() {
        return sellingFormat;
    }

    public Listing setSellingFormat(SellingFormat sellingFormat) {
        this.sellingFormat = sellingFormat;
        return this;
    }

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "delivery_domstic_id")
    public DeliveryOptions getDeliveryDomestic() {
        return deliveryDomestic;
    }

    public Listing setDeliveryDomestic(DeliveryOptions deliveryOptions) {
        this.deliveryDomestic = deliveryOptions;
        return this;
    }
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "delivery_international_id")
    public DeliveryOptions getDeliveryInternational() {
        return deliveryInternational;
    }

    public Listing setDeliveryInternational(DeliveryOptions deliveryOptions) {
        this.deliveryInternational = deliveryOptions;
        return this;
    }

   @ManyToOne(cascade = {CascadeType.ALL})
   @JoinColumn(name = "payment_id")
    public Payment getPayment() {
        return payment;
    }

    public Listing setPayment(Payment payment) {
        this.payment = payment;
        return this;
    }
}
