package com.project.shop.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collection;

@Entity
@Table(name = "payments")
public class Payment extends Item {
    private Collection<Listing> listings;

    public Payment() {
    }

    @OneToMany(mappedBy = "payment", targetEntity = Listing.class, orphanRemoval = true, cascade = CascadeType.ALL)

    public Collection<Listing> getListings() {
        return listings;
    }

    public Payment setListings(Collection<Listing> listings) {
        this.listings = listings;
        return this;
    }
}
