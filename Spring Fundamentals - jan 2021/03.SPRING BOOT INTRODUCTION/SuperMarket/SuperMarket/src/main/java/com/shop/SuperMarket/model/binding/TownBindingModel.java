package com.shop.SuperMarket.model.binding;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@NoArgsConstructor
@Getter
@Setter

public class TownBindingModel {

    @Length(min = 2, message = "Name must be min 2 characters")
    private String name;
}
