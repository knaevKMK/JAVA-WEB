package com.project.shop.infrastructure.identity.models;

import java.util.Set;

public class AccountServiceModel {
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private Set<AppUserRoleEntity> role;

    public AccountServiceModel() {
    }

    public String getFirstName() {
        return firstName;
    }

    public AccountServiceModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public AccountServiceModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public AccountServiceModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public AccountServiceModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public AccountServiceModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public Set<AppUserRoleEntity> getRole() {
        return role;
    }

    public AccountServiceModel setRole(Set<AppUserRoleEntity> role) {
        this.role = role;
        return this;
    }
}
