package com.project.shop.model.view;

public class OwnAccountVewModel extends  AccountViewModel{
    private String firstName;
    private String lastName;

    public OwnAccountVewModel() {
    }

    public String getFirstName() {
        return firstName;
    }

    public OwnAccountVewModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public OwnAccountVewModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
}
