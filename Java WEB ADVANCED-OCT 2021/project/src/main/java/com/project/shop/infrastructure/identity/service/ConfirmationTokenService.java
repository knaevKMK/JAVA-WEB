package com.project.shop.infrastructure.identity.service;

import com.project.shop.infrastructure.identity.models.ConfirmationToken;

import java.util.Optional;

public interface ConfirmationTokenService {
    ConfirmationToken saveConfirmationToken(ConfirmationToken confirmationToken);
    Optional<ConfirmationToken> getToken(String confirmationToken);
    int setConfirmedAt(String token);
}
