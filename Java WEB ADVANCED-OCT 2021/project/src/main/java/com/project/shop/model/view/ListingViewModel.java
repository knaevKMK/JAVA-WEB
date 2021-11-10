package com.project.shop.model.view;

import java.util.UUID;

public class ListingViewModel {
    private UUID id;

    public ListingViewModel() {
    }

    public UUID getId() {
        return id;
    }

    public ListingViewModel setId(UUID id) {
        this.id = id;
        return this;
    }
}
