package com.project.shop.model.binding;

import com.project.shop.model.enums.DeliveryServiceEnum;

import java.math.BigDecimal;

public class DeliveryBindingModel {
    private DeliveryServiceEnum deliveryService;
    private BigDecimal price;

    public DeliveryBindingModel() {
    }

    public DeliveryServiceEnum getDeliveryService() {
        return deliveryService;
    }

    public DeliveryBindingModel setDeliveryService(DeliveryServiceEnum deliveryService) {
        this.deliveryService = deliveryService;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public DeliveryBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
}
