package com.project.shop.infrastructure.identity.DAO;

import com.project.shop.infrastructure.identity.models.JwtResponse;
import com.project.shop.infrastructure.identity.models.LoginRequest;
import javassist.NotFoundException;

public interface LoginHandler {
    JwtResponse login(LoginRequest request) throws NotFoundException;
}
