package com.project.shop.infrastructure.identity.models.service;

import com.project.shop.infrastructure.identity.models.entity.AppUserRoleEntity;

import java.util.Set;

public class UserServiceModel {
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private Set<AppUserRoleEntity> role;

    public UserServiceModel() {
    }

    public String getFirstName() {
        return firstName;
    }

    public UserServiceModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserServiceModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserServiceModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserServiceModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserServiceModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public Set<AppUserRoleEntity> getRole() {
        return role;
    }

    public UserServiceModel setRole(Set<AppUserRoleEntity> role) {
        this.role = role;
        return this;
    }
}
