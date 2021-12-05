package com.project.shop.model.binding;

import com.project.shop.model.enums.ConditionEnum;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public class ConditionBindingModel {
    private String title;
    private UUID id;

    public ConditionBindingModel() {
    }

    public String getTitle() {
        return title;
    }

    public ConditionBindingModel setTitle(String title) {
        this.title = title;
        return this;
    }
@NotNull
    public UUID getId() {
        return id;
    }

    public ConditionBindingModel setId(UUID id) {
        this.id = id;
        return this;
    }
}
