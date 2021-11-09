package com.project.shop.model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "offers")
public class Offer extends BaseEntity {
    private BigDecimal placedOfferPrice;
    private BigDecimal highBoundAcceptOfferPrice;
    private BigDecimal minBoundDeclinedOfferPrice;
    private int hourValidOffer;
    private boolean accepted;

    public Offer() {
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
