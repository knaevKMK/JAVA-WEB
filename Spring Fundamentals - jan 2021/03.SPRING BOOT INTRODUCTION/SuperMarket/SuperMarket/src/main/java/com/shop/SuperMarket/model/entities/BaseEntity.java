package com.shop.SuperMarket.model.entities;

import javax.persistence.*;
import java.util.UUID;

@MappedSuperclass
public abstract class BaseEntity {

    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected UUID id= UUID.randomUUID();


}
