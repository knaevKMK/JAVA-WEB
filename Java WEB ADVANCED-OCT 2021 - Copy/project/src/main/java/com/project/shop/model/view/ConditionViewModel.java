package com.project.shop.model.view;

import java.util.UUID;

public class ConditionViewModel {
    private UUID id;
    private String title;

    public ConditionViewModel() {
    }

    public UUID getId() {
        return id;
    }

    public ConditionViewModel setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public ConditionViewModel setTitle(String title) {
        this.title = title;
        return this;
    }


}
