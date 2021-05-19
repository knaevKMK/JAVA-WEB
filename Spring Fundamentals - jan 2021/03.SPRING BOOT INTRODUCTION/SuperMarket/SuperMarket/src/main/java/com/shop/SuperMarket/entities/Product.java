package com.shop.SuperMarket.entities;


import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "products")
public class Product extends BaseEntity {

    @Column(name = "best_before")
    private Instant bestBefore;

    private String description;

    private BigDecimal price;

    @ManyToOne
    private Category category;
    @ManyToMany
    private List<Shop> shops;
}
