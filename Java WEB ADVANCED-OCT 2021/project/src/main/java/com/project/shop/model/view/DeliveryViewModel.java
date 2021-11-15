package com.project.shop.model.view;

import java.math.BigDecimal;

public class DeliveryViewModel {
    private String deliveryService;
    private BigDecimal price;

    public DeliveryViewModel() {
    }

    public String getDeliveryService() {
        return deliveryService;
    }

    public DeliveryViewModel setDeliveryService(String deliveryService) {
        this.deliveryService = deliveryService;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public DeliveryViewModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
}
