package com.project.shop.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "accounts")
public class Account extends BaseEntity{
    private String username;
    private String email;
    private String token;
private List<Listing> watchList;
private List<Listing> sellingList;
private List<Order> purchaseList;

    public Account() {
    }
    @ManyToMany
    @JoinTable(
            name = "buyer_watchings",
            joinColumns = @JoinColumn(name = "buyer_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "listing_id", referencedColumnName = "id"))
    public List<Listing> getWatchList() {
        return watchList;
    }

    public Account setWatchList(List<Listing> watchList) {
        this.watchList = watchList;
        return this;
    }
    @OneToMany(mappedBy = "seller")
    public List<Listing> getSellingList() {
        return sellingList;
    }

    public Account setSellingList(List<Listing> sellingList) {
        this.sellingList = sellingList;
        return this;
    }
    @OneToMany(mappedBy = "buyer")
    public List<Order> getPurchaseList() {
        return purchaseList;
    }

    public Account setPurchaseList(List<Order> purchaseList) {
        this.purchaseList = purchaseList;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public Account setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Account setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getToken() {
        return token;
    }

    public Account setToken(String token) {
        this.token = token;
        return this;
    }
}
