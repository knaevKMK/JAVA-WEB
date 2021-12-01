package com.project.shop.identityArea.request;

import com.project.shop.identityArea.models.binding.RegisterRequest;

import java.io.IOException;

public interface RegisterHandler {
    String confirmToken(String token);
    String register(RegisterRequest registrationRequest);
    void seed5Accounts() throws IOException;
}
