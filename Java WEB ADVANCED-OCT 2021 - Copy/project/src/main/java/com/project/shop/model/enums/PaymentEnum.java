package com.project.shop.model.enums;

public enum PaymentEnum {
    CASH("Cash"),
    CASH_ON_COLLECT("Cash on Collect"),
    PAYPAL("PayPal"),
    BANK_TRANSFER("Bank Transfer");
    private String title;

    PaymentEnum(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
