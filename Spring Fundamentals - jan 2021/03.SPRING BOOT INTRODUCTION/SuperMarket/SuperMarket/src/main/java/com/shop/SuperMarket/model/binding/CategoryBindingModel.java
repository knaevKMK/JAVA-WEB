package com.shop.SuperMarket.model.binding;


import lombok.*;
import org.hibernate.validator.constraints.Length;


@NoArgsConstructor
@Getter
@Setter
public class CategoryBindingModel {

    @Length(min = 2, message = "Name must be min 2 characters")
    private String name;

}
