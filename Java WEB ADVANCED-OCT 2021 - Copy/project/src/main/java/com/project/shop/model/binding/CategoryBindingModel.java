package com.project.shop.model.binding;

import com.project.shop.model.enums.CategoryEnum;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public class CategoryBindingModel {
    private String parentTitle;
    private String title;
    private UUID id;

    public CategoryBindingModel() {
    }

    public CategoryBindingModel(String title, UUID id) {
        this.title = title;
        this.id = id;
    }

    public String getParentTitle() {
        return parentTitle;
    }

    public CategoryBindingModel setParentTitle(String parentTitle) {
        this.parentTitle = parentTitle;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public CategoryBindingModel setTitle(String  title) {
        this.title = title;
        return this;
    }
@NotNull
    public UUID getId() {
        return id;
    }

    public CategoryBindingModel setId(UUID id) {
        this.id = id;
        return this;
    }
}
