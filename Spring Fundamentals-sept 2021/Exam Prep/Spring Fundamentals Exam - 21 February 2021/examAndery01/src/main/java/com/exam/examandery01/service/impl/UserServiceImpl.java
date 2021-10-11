package com.exam.examandery01.service.impl;

import com.exam.examandery01.model.binding.UserLoginBindingModel;
import com.exam.examandery01.model.binding.UserRegisterBindingModel;
import com.exam.examandery01.model.entity.User;
import com.exam.examandery01.model.services.UserServiceModel;
import com.exam.examandery01.repository.UserRepository;
import com.exam.examandery01.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public UserServiceModel add(UserServiceModel model) {
        User user = modelMapper.map(model, User.class);
        User savedUser = userRepository.saveAndFlush(user);
        UserServiceModel _return= modelMapper.map(savedUser,UserServiceModel.class);
        return _return;
    }

    @Override
    public UserServiceModel FindByUsername(UserLoginBindingModel model) {

        return  this.userRepository
                .findByUsername(model.getUsername())
                .map(user->modelMapper.map(user,UserServiceModel.class))
                .orElse(null);
    }


}
