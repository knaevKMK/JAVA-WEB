package com.exam.examandery01.model.services;

import java.math.BigDecimal;

public class UserServiceModel {
private String username;
private String email;
private  String password;
private BigDecimal budget;

    public UserServiceModel() {
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public UserServiceModel setBudget(BigDecimal budget) {
        this.budget = budget;
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
}
