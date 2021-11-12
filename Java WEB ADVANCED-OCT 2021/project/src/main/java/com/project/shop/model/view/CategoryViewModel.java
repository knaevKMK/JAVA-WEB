package com.project.shop.model.view;

import com.project.shop.model.entity.CategoryItem;

import java.util.UUID;

public class CategoryViewModel {
    private UUID id;
    private String title;
 private String parent;

    public CategoryViewModel() {
    }

    public UUID getId() {
        return id;
    }

    public CategoryViewModel setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public CategoryViewModel setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getParent() {
        return parent;
    }

    public CategoryViewModel setParent(String parent) {
        this.parent = parent;
        return this;
    }
}
