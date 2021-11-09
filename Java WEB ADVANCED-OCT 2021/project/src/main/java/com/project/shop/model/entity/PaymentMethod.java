package com.project.shop.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "payments")
public class PaymentMethod extends BaseEntity {
    private String paymentName;
    private String paymentDescription;
    private String paymentData;

    public PaymentMethod() {
    }
@Column(nullable = false)
    public String getPaymentName() {
        return paymentName;
    }

    public PaymentMethod setPaymentName(String paymentName) {
        this.paymentName = paymentName;
        return this;
    }

    public String getPaymentDescription() {
        return paymentDescription;
    }

    public PaymentMethod setPaymentDescription(String paymentDescripton) {
        this.paymentDescription = paymentDescripton;
        return this;
    }

    public String getPaymentData() {
        return paymentData;
    }

    public PaymentMethod setPaymentData(String paymentData) {
        this.paymentData = paymentData;
        return this;
    }
}
