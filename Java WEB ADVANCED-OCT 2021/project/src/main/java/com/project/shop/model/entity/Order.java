package com.project.shop.model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "oreders")
public class Order extends  Item{
    private List<Listing> listings;
    private Account Buyer;
    private Feedback feedback;
}
