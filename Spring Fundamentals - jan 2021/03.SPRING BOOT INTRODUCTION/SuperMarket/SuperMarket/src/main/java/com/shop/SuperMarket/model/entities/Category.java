package com.shop.SuperMarket.model.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Category extends BaseEntity {


    private String name;
//    @OneToMany
//    private List<Product> products;


}
