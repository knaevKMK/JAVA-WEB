package com.exam2.exam2.service.impl;

import com.exam2.exam2.repositories.UserRepository;
import com.exam2.exam2.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
}
