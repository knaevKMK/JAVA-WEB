package com.shop.SuperMarket.model.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "shops")
@NoArgsConstructor
@Getter
@Setter
public class Shop extends BaseEntity {


    private String name;
    private String address;

    @ManyToOne
    private Town town;

    @ManyToMany(mappedBy = "shops",targetEntity = Product.class)
    private List<Product> products;
}
