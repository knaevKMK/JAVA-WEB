package com.exam.prepare.service.impl;

import com.exam.prepare.model.entities.UserEntity;
import com.exam.prepare.model.service.UserServiceModel;
import com.exam.prepare.repositories.UserRepository;
import com.exam.prepare.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public void registerUser(UserServiceModel userServiceModel) {
        UserEntity user = this.modelMapper.map(userServiceModel, UserEntity.class);
        this.userRepository.save(user);

    }

    @Override
    public UserServiceModel findByUsernameAndPassword(String username, String password) {
        return this.userRepository
                .findByUsernameAndPassword(username,password)
                .map(userEntity -> modelMapper.map(userEntity,UserServiceModel.class))
                .orElse(null);
    }
}
