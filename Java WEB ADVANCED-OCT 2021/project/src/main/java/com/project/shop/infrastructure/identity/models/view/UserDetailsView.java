package com.project.shop.infrastructure.identity.models.view;

public class UserDetailsView {
    private String username;
    private  String fullName;

    public UserDetailsView() {
    }

    public UserDetailsView(String username, String fullName) {
        this.username=username;
        this.fullName=fullName;
    }

    public String getUsername() {
        return username;
    }

    public UserDetailsView setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UserDetailsView setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }
}
