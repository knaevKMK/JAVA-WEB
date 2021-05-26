package com.shop.SuperMarket.model.binding;


import com.shop.SuperMarket.model.entities.Product;
import com.shop.SuperMarket.model.entities.Town;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.List;


@NoArgsConstructor
@Getter


public class ShopBindingModel {

    private String name;
    private String address;
    private Town town;



}
