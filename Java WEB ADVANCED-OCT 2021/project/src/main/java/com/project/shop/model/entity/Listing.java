package com.project.shop.model.entity;



import com.project.shop.infrastructure.identity.models.Account;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "listings")
public class Listing extends Item {

    private String imageUrl;
    private CategoryItem category;
    private ConditionItem condition;
    private Account seller;

    private Set<Account> watchers;
    private Order order;
    private SellingFormat sellingFormat;
    private DeliveryOptions deliveryDomestic;
    private DeliveryOptions deliveryInternational;
    private List<Offer> offers;
    private String payment;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "selling_format_id", referencedColumnName = "id")
    public SellingFormat getSellingFormat() {
        return sellingFormat;
    }

    public Listing setSellingFormat(SellingFormat sellingFormat) {
        this.sellingFormat = sellingFormat;
        return this;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_domstic_id", referencedColumnName = "id")
    public DeliveryOptions getDeliveryDomestic() {
        return deliveryDomestic;
    }

    public Listing setDeliveryDomestic(DeliveryOptions deliveryOptions) {
        this.deliveryDomestic = deliveryOptions;
        return this;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_international_id", referencedColumnName = "id")
    public DeliveryOptions getDeliveryInternational() {
        return deliveryInternational;
    }

    public Listing setDeliveryInternational(DeliveryOptions deliveryOptions) {
        this.deliveryInternational = deliveryOptions;
        return this;
    }

 //   @ManyToOne
    public String getPayment() {
        return payment;
    }

    public Listing setPayment(String payment) {
        this.payment = payment;
        return this;
    }
}
