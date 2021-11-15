package com.project.shop.model.binding;

import com.project.shop.model.enums.CategoryEnum;

import java.util.UUID;

public class CategoryBindingModel {
    private String title;
    private UUID id;

    public CategoryBindingModel(String title, UUID id) {
        this.title = title;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public CategoryBindingModel setTitle(String  title) {
        this.title = title;
        return this;
    }

    public UUID getId() {
        return id;
    }

    public CategoryBindingModel setId(UUID id) {
        this.id = id;
        return this;
    }
}
