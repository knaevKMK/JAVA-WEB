package com.project.shop.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "accounts")
public class Account extends BaseEntity {
    private String username;
    private Set<Listing> watchList = new HashSet<>();
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
    public Set<Listing> getWatchList() {
        return watchList;
    }

    public Account setWatchList(Set<Listing> watchList) {
        this.watchList = watchList;
        return this;
    }


    @OneToMany(mappedBy = "buyer", cascade = {CascadeType.DETACH})
    public List<Order> getPurchaseList() {
        return purchaseList;
    }

    public Account setPurchaseList(List<Order> purchaseList) {
        this.purchaseList = purchaseList;
        return this;
    }


}
