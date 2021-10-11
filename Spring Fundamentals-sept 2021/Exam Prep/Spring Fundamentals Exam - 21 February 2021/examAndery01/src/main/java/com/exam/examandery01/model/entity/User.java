package com.exam.examandery01.model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name="users")
public class User extends  BaseEntity{

    private String username;
    private  String password;
    private  String email;
    private BigDecimal budget;

    public User() {
    }
//TODO validations
    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public User setBudget(BigDecimal budget) {
        this.budget = budget;
        return this;
    }
}
