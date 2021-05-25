package com.shop.SuperMarket.model.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
@NoArgsConstructor
@Getter
@Setter
public class Category extends BaseEntity{


    private String category;
//    @OneToMany
//    private List<Product> products;


}
