package com.project.shop.model.enums;

import java.math.BigDecimal;

public enum SellingFormatEnum {
    FIXED(new int[]{7,14,30},0,1),
    ACTION(new int[]{1,3,5,7},0,1);
 //   HYBRID(FIXED,ACTION);

    private int[] duration;
    private BigDecimal price;
    private int quantity;

    SellingFormatEnum(int[] dayDuration,double price,int quantiy) {
        this.duration=dayDuration;
        this.price=BigDecimal.valueOf(price);
        this.quantity=quantiy;
    }

    public int[] getDuration() {
        return duration;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }


}
