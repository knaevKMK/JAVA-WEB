package com.project.shop.model.entity;

import com.project.shop.infrastructure.identity.models.Account;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "app_users")
public class AppUserEntity extends BaseEntity {
    private Account account;
    private List<Listing> watchList = new ArrayList<>();
    private List<Listing> sellingList = new ArrayList<>();
    private List<Order> purchaseList = new ArrayList<>();

    public AppUserEntity() {
    }

    @OneToOne(optional = false)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    public Account getAccount() {
        return account;
    }

    public AppUserEntity setAccount(Account account) {
        this.account = account;
        return this;
    }

    @ManyToMany
    @JoinTable(
            name = "buyer_watchings",
            joinColumns = @JoinColumn(name = "buyer_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "listing_id", referencedColumnName = "id"))
    public List<Listing> getWatchList() {
        return watchList;
    }

    public AppUserEntity setWatchList(List<Listing> watchList) {
        this.watchList = watchList;
        return this;
    }

    @OneToMany(mappedBy = "seller")
    public List<Listing> getSellingList() {
        return sellingList;
    }

    public AppUserEntity setSellingList(List<Listing> sellingList) {
        this.sellingList = sellingList;
        return this;
    }

    @OneToMany(mappedBy = "buyer")
    public List<Order> getPurchaseList() {
        return purchaseList;
    }

    public AppUserEntity setPurchaseList(List<Order> purchaseList) {
        this.purchaseList = purchaseList;
        return this;
    }
}
