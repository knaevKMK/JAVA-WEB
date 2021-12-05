package com.project.shop.model.binding;


import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public class MsgBindingModel {
    private String recipientUsername;
    private UUID listingId;
    private String text;

    public MsgBindingModel() {
    }

    public String getRecipientUsername() {
        return recipientUsername;
    }

    public MsgBindingModel setRecipientUsername(String recipientUsername) {
        this.recipientUsername = recipientUsername;
        return this;
    }
@NotNull
    public UUID getListingId() {
        return listingId;
    }

    public MsgBindingModel setListingId(UUID listingId) {
        this.listingId = listingId;
        return this;
    }
@NotNull
@NotEmpty
@NotBlank
@Length(min = 3,max = 200)
    public String getText() {
        return text;
    }

    public MsgBindingModel setText(String text) {
        this.text = text;
        return this;
    }
}
