package com.registration.controller;


import com.registration.entity.User;
import com.registration.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@AllArgsConstructor
public class Api {

    private final UserService userService;

    @GetMapping("/user/email_:{email}")
    public User findUserByEmail(@PathVariable("email") String email) {
        return this.userService.findUserByEmail(email);
    }

    @GetMapping("/user/username_:{username}")
    public User findUserByUsername(@PathVariable("username") String username) {
        return this.userService.findUserByUsername(username);
    }

    @PostMapping("/registration/create")
    public User createUser(@RequestBody User user) {
        return this.userService.createUser(user);
    }
}
