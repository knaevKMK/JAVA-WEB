package com.project.shop.model.view;

import java.util.UUID;

public class CategoryViewInListingModel {
    private UUID id;
    private String title;

    public CategoryViewInListingModel() {
    }

    public UUID getId() {
        return id;
    }

    public CategoryViewInListingModel setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public CategoryViewInListingModel setTitle(String title) {
        this.title = title;
        return this;
    }

}
