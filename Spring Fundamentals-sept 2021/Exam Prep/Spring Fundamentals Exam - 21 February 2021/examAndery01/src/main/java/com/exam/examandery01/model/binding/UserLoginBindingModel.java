package com.exam.examandery01.model.binding;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class UserLoginBindingModel {
    private String username;
    private String password;

    public UserLoginBindingModel() {
    }

    @NotNull(message = "Username is Required")
    @Length(min = 2, message = "Username MIN LENGTH IS 2 CHARACTERS")

    public String getUsername() {
        return username;
    }

    public UserLoginBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    @NotNull(message = "Password is required")
    @Length(min = 2, message = "PASSWORD MIN LENGTH IS 2 CHARACTERS")

    public String getPassword() {
        return password;
    }

    public UserLoginBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
