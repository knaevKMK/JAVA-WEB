package com.project.shop.model.entity;

import com.project.shop.model.enums.DeliveryServiceEnum;
import com.project.shop.model.enums.DeliveryTypeEnum;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "delivery_options")
public class DeliveryOptions extends BaseEntity{
    private DeliveryTypeEnum deliveryArea;
    private DeliveryServiceEnum deliveryService;
    private BigDecimal price;

    public DeliveryOptions() {
    }

    public DeliveryTypeEnum getDeliveryArea() {
        return deliveryArea;
    }

    public DeliveryOptions setDeliveryArea(DeliveryTypeEnum deliveryArea) {
        this.deliveryArea = deliveryArea;
        return this;
    }

    public DeliveryServiceEnum getDeliveryService() {
        return deliveryService;
    }

    public DeliveryOptions setDeliveryService(DeliveryServiceEnum deliveryService) {
        this.deliveryService = deliveryService;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public DeliveryOptions setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
}
