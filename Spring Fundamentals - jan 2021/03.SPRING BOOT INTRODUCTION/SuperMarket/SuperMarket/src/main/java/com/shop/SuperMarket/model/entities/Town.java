package com.shop.SuperMarket.model.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "towns")
@NoArgsConstructor
@Getter
@Setter
public class Town extends BaseEntity {
    private String name;


}
