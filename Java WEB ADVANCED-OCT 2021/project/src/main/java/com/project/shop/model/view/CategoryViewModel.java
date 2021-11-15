package com.project.shop.model.view;

import com.project.shop.model.entity.CategoryItem;

import java.util.Collection;
import java.util.UUID;

public class CategoryViewModel {
    private UUID id;
    private String title;
 private Collection<CategoryViewModel> subList;

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

    public Collection<CategoryViewModel> getSubList() {
        return subList;
    }

    public CategoryViewModel setSubList(Collection<CategoryViewModel> subList) {
        this.subList = subList;
        return this;
    }
}
