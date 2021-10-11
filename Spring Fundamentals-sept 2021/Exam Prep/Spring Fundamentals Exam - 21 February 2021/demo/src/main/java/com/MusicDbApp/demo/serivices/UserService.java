package com.MusicDbApp.demo.serivices;

import com.MusicDbApp.demo.models.entities.User;
import com.MusicDbApp.demo.models.service.UserServiceModel;
import com.MusicDbApp.demo.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }



    public void registerUser(UserServiceModel userServiceModel) {
        User user = this.modelMapper.map(userServiceModel, User.class);
        this.userRepository.save(user);
    }


    public UserServiceModel findByUsernameAndPassword(String username, String password) {
        return this.userRepository
                .findByUserNameAndPassword(username,password)
                .map(userEntity -> modelMapper.map(userEntity,UserServiceModel.class))
                .orElse(null);
    }
}
