package com.project.shop.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
public class CategoryItem extends Item{


private CategoryItem parentCategory;
private List<CategoryItem> subCategories;
    public CategoryItem() {
    }
@OneToMany(mappedBy = "parentCategory")
    public List<CategoryItem> getSubCategories() {
        return subCategories;
    }

    public CategoryItem setSubCategories(List<CategoryItem> subCategories) {
        this.subCategories = subCategories;
        return this;
    }

    @ManyToOne(cascade={CascadeType.ALL})
    @JoinColumn(name = "parent_category_id")
    public CategoryItem getParentCategory() {
        return parentCategory;
    }

    public CategoryItem setParentCategory(CategoryItem parentCategory) {
        this.parentCategory = parentCategory;
        return this;
    }
}
