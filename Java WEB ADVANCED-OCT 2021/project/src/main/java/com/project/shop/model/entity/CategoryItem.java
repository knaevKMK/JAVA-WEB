package com.project.shop.model.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
public class CategoryItem extends Item{



    public CategoryItem() {
    }


}
