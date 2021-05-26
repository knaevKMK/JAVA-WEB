package com.shop.SuperMarket.model.service;


import com.shop.SuperMarket.model.entities.Product;
import com.shop.SuperMarket.model.entities.Town;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ShopServiceModel {

    private String name;
    private String address;
    private Town town;
    private List<Product> products = new ArrayList<>();
}
