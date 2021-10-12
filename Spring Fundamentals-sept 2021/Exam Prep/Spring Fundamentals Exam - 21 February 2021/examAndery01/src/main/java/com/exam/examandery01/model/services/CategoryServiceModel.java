package com.exam.examandery01.model.services;

import com.exam.examandery01.model.entity.CategoryName;

public class CategoryServiceModel {
    private CategoryName category;
    private  String description;

    public CategoryServiceModel() {
    }

    public String getDescription() {
        return description;
    }

    public CategoryServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public CategoryName getCategory() {
        return category;
    }

    public CategoryServiceModel setCategory(CategoryName category) {
        this.category = category;
        return this;
    }
}
