package com.shop.SuperMarket.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "shops")
@Getter
@Setter
public class Shop extends BaseEntity {
//TODO •	id – a char sequence
//•	address – a char sequence. It's unique and cannot be null. Must be at least 2 characters.
//•	name – a char sequence. Must be at least 2 characters.


    private String address;

    @ManyToOne
    private Town town;


//    @OneToMany
//    private Set<Seller> sellers;
//
//    @ManyToMany
//    private List<Product> products;
}
