package com.project.shop.model.entity;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
public class CategoryItem extends Item{


private CategoryItem parentCategory;
private List<CategoryItem> subCategories;

private List<Listing> listings;
    public CategoryItem() {
        this.listings=new ArrayList<>();
    }
@OneToMany(mappedBy = "category",targetEntity = Listing.class,orphanRemoval = true,cascade = CascadeType.ALL)
@NotFound(action= NotFoundAction.IGNORE)
    public List<Listing> getListings() {
        return listings;
    }

    public CategoryItem setListings(List<Listing> listings) {
        this.listings = listings;
        return this;
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
