package com.shop.SuperMarket.model.binding;


import com.shop.SuperMarket.model.entities.Town;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TownBindingModel {

    @Length(min = 2, message = "Name must be min 2 characters")
    private String name;
}
