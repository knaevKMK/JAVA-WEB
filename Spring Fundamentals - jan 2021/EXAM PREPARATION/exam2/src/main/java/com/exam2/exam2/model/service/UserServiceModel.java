package com.exam2.exam2.model.service;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserServiceModel {
    private String id;
    private String username;
    private String password;
    private String email;
}
