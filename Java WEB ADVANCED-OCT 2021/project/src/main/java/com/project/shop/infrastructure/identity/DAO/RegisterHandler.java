package com.project.shop.infrastructure.identity.DAO;

import com.project.shop.infrastructure.identity.models.RegisterRequest;

public interface RegisterHandler {
    String confirmToken(String token);
    String register(RegisterRequest registrationRequest);
}
