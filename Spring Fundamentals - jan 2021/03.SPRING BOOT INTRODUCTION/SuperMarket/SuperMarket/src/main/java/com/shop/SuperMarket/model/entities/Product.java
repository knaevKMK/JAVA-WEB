package com.shop.SuperMarket.model.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "products")
@NoArgsConstructor
@Getter
@Setter
public class Product extends BaseEntity {

    private String name;
    @Column(name = "best_before")
    private Instant bestBefore;

    private String description;


    @Column(name ="price", nullable = false)
    private BigDecimal price;

    @ManyToOne
    private Category category;

    @ManyToMany
    private List<Shop> shops;
}
