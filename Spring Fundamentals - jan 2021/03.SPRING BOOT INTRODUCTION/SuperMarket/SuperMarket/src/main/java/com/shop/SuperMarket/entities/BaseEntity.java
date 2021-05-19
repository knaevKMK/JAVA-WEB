package com.shop.SuperMarket.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@MappedSuperclass
public abstract class BaseEntity {

    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected UUID id= UUID.randomUUID();


    @Column(name = "name")
    protected String name;
}
