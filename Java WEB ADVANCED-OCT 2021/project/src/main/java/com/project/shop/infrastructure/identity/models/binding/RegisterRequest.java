package com.project.shop.infrastructure.identity.models;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class RegisterRequest {
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private String confirmPassword;

    public RegisterRequest() {
    }

    @NotNull
    @NotEmpty
    @Length(min = 2,max = 25)
    public String getFirstName() {
        return firstName;
    }

    public RegisterRequest setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @NotNull
    @NotEmpty
    @Length(min = 2,max = 25)
    public String getLastName() {
        return lastName;
    }

    public RegisterRequest setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @NotNull
    @NotEmpty
    @Length(min = 5,max = 30)
    public String getUsername() {
        return username;
    }

    public RegisterRequest setUsername(String username) {
        this.username = username;
        return this;
    }

    @NotNull
    @NotEmpty
    @Email(regexp = "[_a-zA-Z1-9]+(\\.[A-Za-z0-9]*)*@[A-Za-z0-9]+\\.[A-Za-z0-9]+(\\.[A-Za-z0-9]*)*"
            ,message = "email not match at aaa@bb.gg")
    public String getEmail() {
        return email;
    }

    public RegisterRequest setEmail(String email) {
        this.email = email;
        return this;
    }

    @NotNull
    @NotEmpty
    @Length(min = 5,max =25)
    public String getPassword() {
        return password;
    }

    public RegisterRequest setPassword(String password) {
        this.password = password;
        return this;
    }

    @NotNull
    @NotEmpty
    @Length(min = 5,max = 25)
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public RegisterRequest setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}
