package com.exam.examandery01.service;

import com.exam.examandery01.model.binding.UserLoginBindingModel;
import com.exam.examandery01.model.binding.UserRegisterBindingModel;
import com.exam.examandery01.model.entity.User;
import com.exam.examandery01.model.services.UserServiceModel;
import org.springframework.stereotype.Service;


public interface UserService {
    UserServiceModel add(UserServiceModel model);

    UserServiceModel FindByUsername(UserLoginBindingModel model);
}
