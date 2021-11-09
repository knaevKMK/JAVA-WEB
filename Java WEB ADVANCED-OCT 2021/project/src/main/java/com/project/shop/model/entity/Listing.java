package com.project.shop.model.entity;


import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "listings")
public class Listing extends Item {

   // private Account seller;

    private SellingFormat sellingFormat;
    private DeliveryOptions deliveryOptions;


    private PaymentMethod payment;

}
