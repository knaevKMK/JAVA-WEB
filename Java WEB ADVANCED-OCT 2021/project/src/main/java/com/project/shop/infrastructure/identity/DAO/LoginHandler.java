package com.project.shop.infrastructure.identity.DAO;

import com.project.shop.infrastructure.identity.models.view.JwtResponse;
import com.project.shop.infrastructure.identity.models.binding.LoginRequest;
import javassist.NotFoundException;

public interface LoginHandler {
    JwtResponse login(LoginRequest request) throws NotFoundException;
}
