package com.project.shop.infrastructure.identity.models;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class LoginRequest {
    private String username;
    private String password;

    public LoginRequest() {
    }
    @NotNull
    @NotEmpty
    @Length(min = 5,max = 30)
    public String getUsername() {
        return username;
    }

    public LoginRequest setUsername(String username) {
        this.username = username;
        return this;
    }
    @NotNull
    @NotEmpty
    @Length(min = 5,max = 30)
    public String getPassword() {
        return password;
    }

    public LoginRequest setPassword(String password) {
        this.password = password;
        return this;
    }
}
