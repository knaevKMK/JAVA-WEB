package com.project.shop.model.entity;

import com.project.shop.infrastructure.identity.models.entity.UserEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "accounts")
public class Account extends BaseEntity {
    private String username;
    private List<Listing> watchList = new ArrayList<>();
    private List<Listing> sellingList = new ArrayList<>();
    private List<Order> purchaseList = new ArrayList<>();

    public Account() {
    }

    public Account(String username) {
        this.username = username;
    }

    @Column(nullable = false, unique = true)
    public String getUsername() {
        return username;
    }

    public Account setUsername(String username) {
        this.username = username;
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

    @OneToMany(mappedBy = "buyer",cascade={CascadeType.REMOVE})
    public List<Order> getPurchaseList() {
        return purchaseList;
    }

    public Account setPurchaseList(List<Order> purchaseList) {
        this.purchaseList = purchaseList;
        return this;
    }
}
