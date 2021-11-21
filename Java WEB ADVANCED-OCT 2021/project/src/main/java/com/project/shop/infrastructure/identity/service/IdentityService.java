package com.project.shop.infrastructure.identity.service;

import com.project.shop.infrastructure.identity.models.Account;
import com.project.shop.infrastructure.identity.models.JwtResponse;
import javassist.NotFoundException;

public interface IdentityService {
    String confirmToken(String token);

    String signUpUser(Account account);

    void initializeUsersAndRoles();
    JwtResponse login(String username, String password) throws NotFoundException;
Account findByUsername(String username);
}
