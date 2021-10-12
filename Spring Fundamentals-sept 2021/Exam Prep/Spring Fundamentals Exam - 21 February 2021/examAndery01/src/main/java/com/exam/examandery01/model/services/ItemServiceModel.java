package com.exam.examandery01.model.services;

import com.exam.examandery01.model.entity.Category;
import com.exam.examandery01.model.entity.CategoryName;
import com.exam.examandery01.model.entity.GenderName;

import java.math.BigDecimal;

public class ItemServiceModel {

    private String name;
    private String description;
    private CategoryServiceModel category;
    private GenderName gender;
    private BigDecimal price;

    public ItemServiceModel() {
    }

    public String getName() {
        return name;
    }

    public ItemServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ItemServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public CategoryServiceModel getCategory() {
        return category;
    }

    public ItemServiceModel setCategory(CategoryServiceModel category) {
        this.category = category;
        return this;
    }

    public GenderName getGender() {
        return gender;
    }

    public ItemServiceModel setGender(GenderName gender) {
        this.gender = gender;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ItemServiceModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
}
