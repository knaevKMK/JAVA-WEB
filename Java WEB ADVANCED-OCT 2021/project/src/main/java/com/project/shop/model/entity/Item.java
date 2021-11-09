package com.project.shop.model.entity;

import javax.persistence.*;

@MappedSuperclass
public abstract class Item extends  BaseEntity{

    private String itemTitle;
    private String itemDescription;
    private String imageUrl;
    private CategoryItem itemCategoryItem;
    private ConditionItem itemCondition;

    public Item() {
    }
@Column(nullable = false)
    public String getItemTitle() {
        return itemTitle;
    }

    public Item setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
        return this;
    }
@Column(columnDefinition = "TEXT",nullable = false)
    public String getItemDescription() {
        return itemDescription;
    }

    public Item setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
        return this;
    }
@Column(nullable = false)
    public String getImageUrl() {
        return imageUrl;
    }

    public Item setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
@ManyToOne
    public CategoryItem getItemCategoryItem() {
        return itemCategoryItem;
    }

    public Item setItemCategoryItem(CategoryItem itemCategoryItem) {
        this.itemCategoryItem = itemCategoryItem;
        return this;
    }
@ManyToOne
    public ConditionItem getItemCondition() {
        return itemCondition;
    }

    public Item setItemCondition(ConditionItem itemCondition) {
        this.itemCondition = itemCondition;
        return this;
    }
}
