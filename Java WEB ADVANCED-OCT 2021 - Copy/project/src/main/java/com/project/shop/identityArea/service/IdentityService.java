package com.project.shop.identityArea.service;

import com.project.shop.identityArea.models.entity.UserEntity;
import com.project.shop.identityArea.models.view.JwtResponse;
import javassist.NotFoundException;

import java.io.IOException;
import java.util.Optional;

public interface IdentityService  {
    String enableAccount(String token);

    String registerUser(UserEntity userEntity);

    void initializeUsersAndRoles();
    JwtResponse login(String username, String password) throws NotFoundException;
    Optional<UserEntity> findByUsername(String username);

    Optional<UserEntity> findByEmail(String email);


}
