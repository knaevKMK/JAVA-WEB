package com.project.shop.identityArea.request;

import com.project.shop.identityArea.models.view.JwtResponse;
import com.project.shop.identityArea.models.binding.LoginRequest;
import javassist.NotFoundException;

public interface LoginHandler {
    JwtResponse login(LoginRequest request) throws NotFoundException;
}
