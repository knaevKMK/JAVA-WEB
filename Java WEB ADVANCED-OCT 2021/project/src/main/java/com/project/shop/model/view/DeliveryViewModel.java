package com.project.shop.model.view;

import java.math.BigDecimal;
import java.util.List;

public class DeliveryViewModel {
    private String deliveryArea;
    private List<String> deliveryService;
    private BigDecimal price;

    public DeliveryViewModel() {
    }

    public String getDeliveryArea() {
        return deliveryArea;
    }

    public DeliveryViewModel setDeliveryArea(String deliveryArea) {
        this.deliveryArea = deliveryArea;
        return this;
    }

    public List<String> getDeliveryService() {
        return deliveryService;
    }

    public DeliveryViewModel setDeliveryService(List<String> deliveryService) {
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
