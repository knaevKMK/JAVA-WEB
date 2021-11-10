package com.project.shop.model.binding;

import java.util.UUID;

public class ListingCreateModel {
    private UUID id;

    public ListingCreateModel() {
    }

    public UUID getId() {
        return id;
    }

    public ListingCreateModel setId(UUID id) {
        this.id = id;
        return this;
    }
}
