package com.project.shop.model.entity;


import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "delivery_options")
public class DeliveryOptions extends BaseEntity{
    private String deliveryService;
    private BigDecimal price;

    public DeliveryOptions() {
    }


    public String getDeliveryService() {
        return deliveryService;
    }

    public DeliveryOptions setDeliveryService(String deliveryService) {
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
