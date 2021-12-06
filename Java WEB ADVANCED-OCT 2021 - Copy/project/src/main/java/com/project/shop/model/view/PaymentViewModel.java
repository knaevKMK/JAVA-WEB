package com.project.shop.model.view;

import java.util.UUID;

public class PaymentViewModel {
    private String title;
    private UUID id;

    public PaymentViewModel() {
    }

    public String getTitle() {
        return title;
    }

    public PaymentViewModel setTitle(String title) {
        this.title = title;
        return this;
    }

    public UUID getId() {
        return id;
    }

    public PaymentViewModel setId(UUID id) {
        this.id = id;
        return this;
    }
}
