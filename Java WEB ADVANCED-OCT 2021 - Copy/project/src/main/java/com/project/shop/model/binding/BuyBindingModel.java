package com.project.shop.model.binding;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.UUID;

public class BuyBindingModel {
    private UUID id;
    private int quantity;
    private BigDecimal price;

    public BuyBindingModel() {
    }

    public UUID getId() {
        return id;
    }

    public BuyBindingModel setId(UUID id) {
        this.id = id;
        return this;
    }
@NotNull
@Positive
    public int getQuantity() {
        return quantity;
    }

    public BuyBindingModel setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }
@NotNull
@Positive
    public BigDecimal getPrice() {
        return price;
    }

    public BuyBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
}
