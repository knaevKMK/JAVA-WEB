package com.project.shop.model.service;

import java.util.UUID;

public class ListingServiceModel {
    private UUID id;

    public ListingServiceModel() {
    }

    public UUID getId() {
        return id;
    }

    public ListingServiceModel setId(UUID id) {
        this.id = id;
        return this;
    }
}
