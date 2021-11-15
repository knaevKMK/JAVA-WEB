package com.project.shop.model.binding;

import com.project.shop.model.enums.ConditionEnum;

import java.util.UUID;

public class ConditionBindingModel {
    private ConditionEnum title;
    private UUID id;

    public ConditionBindingModel() {
    }

    public ConditionEnum getTitle() {
        return title;
    }

    public ConditionBindingModel setTitle(ConditionEnum title) {
        this.title = title;
        return this;
    }

    public UUID getId() {
        return id;
    }

    public ConditionBindingModel setId(UUID id) {
        this.id = id;
        return this;
    }
}
