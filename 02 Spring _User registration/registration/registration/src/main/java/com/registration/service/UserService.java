package com.registration.service;


import com.registration.entity.User;
import com.registration.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    @Autowired
    private final UserRepository userRepository;


    public User findUserByEmail(String email) {
        return this.userRepository.findUserByEmail(email);
    }

    public User findUserByUsername(String username) {
        return this.userRepository.findUserByUsername(username);
    }
    public  User createUser(User user){
        User newUser= new User();
        newUser.setUsername(user.getUsername());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        return  this.userRepository.save(newUser);
    }
}
