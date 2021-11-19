package com.project.shop.model.view;

import java.math.BigDecimal;
import java.util.List;

public class DeliveryInListingVewModel {

    private String deliveryService;
    private BigDecimal price;

    public DeliveryInListingVewModel() {
    }

    public String getDeliveryService() {
        return deliveryService;
    }

    public DeliveryInListingVewModel setDeliveryService(String deliveryService) {
        this.deliveryService = deliveryService;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public DeliveryInListingVewModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
}
