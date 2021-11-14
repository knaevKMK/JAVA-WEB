package com.project.shop.model.enums;

import java.math.BigDecimal;

public enum DeliveryServiceEnum {
    SIGNED(5.45),
    TRACKED(5.00),
    EXPRESS(11.98),
    STANDARD(4.65),
    ECONOMY(3.55);

    private final BigDecimal price;

    DeliveryServiceEnum(Double price) {
    this.price=  setPrice(price);
    }

    public BigDecimal getPrice() {
        return (this.price);
    }

    private BigDecimal setPrice(Double price) {
     return  BigDecimal.valueOf(price);

    }
}
