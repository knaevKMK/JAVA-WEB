package com.project.shop.infrastructure.identity.service;

import com.project.shop.infrastructure.identity.models.Account;
import com.project.shop.infrastructure.identity.models.JwtResponse;
import javassist.NotFoundException;

import java.util.Optional;

public interface IdentityService {
    String confirmToken(String token);

    String signUpUser(Account account);

    void initializeUsersAndRoles();
    JwtResponse login(String username, String password) throws NotFoundException;
    Optional<Account> findByUsername(String username);

    Optional<Account> findByEmail(String email);
}
