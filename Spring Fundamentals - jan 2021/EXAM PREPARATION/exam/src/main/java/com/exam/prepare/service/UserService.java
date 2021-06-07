package com.exam.prepare.service;

import com.exam.prepare.model.service.UserServiceModel;

public interface UserService {
    void registerUser(UserServiceModel userServiceModel);
    UserServiceModel findByUsernameAndPassword(String username,String password);
}
