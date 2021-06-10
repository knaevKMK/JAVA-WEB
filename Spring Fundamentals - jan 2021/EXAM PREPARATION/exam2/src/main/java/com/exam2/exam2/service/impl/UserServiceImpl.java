package com.exam2.exam2.service.impl;

import com.exam2.exam2.model.entities.UserEntity;
import com.exam2.exam2.model.service.UserServiceModel;
import com.exam2.exam2.repositories.UserRepository;
import com.exam2.exam2.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public void register(UserServiceModel userServiceModel) {
        UserEntity user = modelMapper.map(userServiceModel, UserEntity.class);
        this.userRepository.save(user);
    }
}
