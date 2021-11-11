package com.project.shop.model.entity;

import javax.persistence.*;

@MappedSuperclass
public abstract class Item extends  BaseEntity{

    private String title;
    private String description;


    public Item() {
    }
@Column(nullable = false)
    public String getTitle() {
        return title;
    }

    public Item setTitle(String itemTitle) {
        this.title = itemTitle;
        return this;
    }
@Column(columnDefinition = "TEXT",nullable = false)
public String getDescription() {
        return description;
    }

    public Item setDescription(String itemDescription) {
        this.description = itemDescription;
        return this;
    }

}
