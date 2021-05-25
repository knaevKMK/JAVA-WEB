package com.shop.SuperMarket.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "sellers")
@NoArgsConstructor
@Getter
@Setter
public class Seller extends BaseEntity {
    //TODO- •	id – a char sequence
    //•	firstName – a char sequence. Cannot be null. Must be at least 2 characters.
    //•	lastName – a char sequence. Cannot be null. Must be at least 2 characters.
    //•	age – an integer. Cannot be null. The person must be at least 18 years old.
    //•	salary – a number (must be a positive number). Cannot be null.


    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;


    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private BigDecimal salary;

    @ManyToOne
    private Seller manager;
    @ManyToOne
    private Shop shop;
}
