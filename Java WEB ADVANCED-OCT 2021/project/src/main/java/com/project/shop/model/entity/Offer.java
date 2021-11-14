package com.project.shop.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "offers")
public class Offer extends BaseEntity {
    private  Listing listing;
    private BigDecimal placedOfferPrice;
    private BigDecimal highBoundAcceptOfferPrice;
    private BigDecimal minBoundDeclinedOfferPrice;
    private int hourValidOffer;
    private boolean accepted;

    public Offer() {
    }
@ManyToOne(cascade = {CascadeType.ALL})
@JoinColumn(name = "selling_id")
    public Listing getListing() {
        return listing;
    }

    public Offer setListing(Listing listing) {
        this.listing = listing;
        return this;
    }

    public BigDecimal getPlacedOfferPrice() {
        return placedOfferPrice;
    }

    public Offer setPlacedOfferPrice(BigDecimal placedOfferPrice) {
        this.placedOfferPrice = placedOfferPrice;
        return this;
    }

    public BigDecimal getHighBoundAcceptOfferPrice() {
        return highBoundAcceptOfferPrice;
    }

    public Offer setHighBoundAcceptOfferPrice(BigDecimal highBoundAcceptOfferPrice) {
        this.highBoundAcceptOfferPrice = highBoundAcceptOfferPrice;
        return this;
    }

    public BigDecimal getMinBoundDeclinedOfferPrice() {
        return minBoundDeclinedOfferPrice;
    }

    public Offer setMinBoundDeclinedOfferPrice(BigDecimal minBoundDeclinedOfferPrice) {
        this.minBoundDeclinedOfferPrice = minBoundDeclinedOfferPrice;
        return this;
    }

    public int getHourValidOffer() {
        return hourValidOffer;
    }

    public Offer setHourValidOffer(int hourValidOffer) {
        this.hourValidOffer = hourValidOffer;
        return this;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public Offer setAccepted(boolean accepted) {
        this.accepted = accepted;
        return this;
    }
}
