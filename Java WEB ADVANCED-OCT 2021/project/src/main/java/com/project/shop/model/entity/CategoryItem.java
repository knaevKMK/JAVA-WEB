package com.project.shop.model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
public class CategoryItem extends BaseEntity{
    private String categoryName;
    private String categoryDescription;
    private CategoryItem parentCategoryItem;

    public CategoryItem() {
    }

    public String getCategoryName() {
        return categoryName;
    }

    public CategoryItem setCategoryName(String categoryName) {
        this.categoryName = categoryName;
        return this;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public CategoryItem setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
        return this;
    }

    public CategoryItem getParentCategory() {
        return parentCategoryItem;
    }

    public CategoryItem setParentCategory(CategoryItem parentCategoryItem) {
        this.parentCategoryItem = parentCategoryItem;
        return this;
    }
}
