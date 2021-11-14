package com.project.shop.model.entity;



import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "listings")
public class Listing extends Item {

    private String imageUrl;
    private CategoryItem itemCategoryItem;
    private ConditionItem itemCondition;
    private Account seller;

    private Set<Account> watchers;
    private Order order;
    private SellingFormat sellingFormat;
    private DeliveryOptions deliveryOptions;
    private List<Offer> offers;
    private PaymentMethod payment;

    public Listing() {
    }

    @OneToMany(mappedBy = "listing")
    public List<Offer> getOffers() {
        return offers;
    }

    public Listing setOffers(List<Offer> offers) {
        this.offers = offers;
        return this;
    }

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "order_id")
    public Order getOrder() {
        return order;
    }

    public Listing setOrder(Order order) {
        this.order = order;
        return this;
    }

    @ManyToMany(mappedBy = "watchList", targetEntity = Account.class)
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
