package com.project.shop.identityArea.service;

import com.project.shop.identityArea.models.entity.ConfirmationToken;

import java.util.Optional;

public interface ConfirmationTokenService {
    ConfirmationToken saveConfirmationToken(ConfirmationToken confirmationToken);
    Optional<ConfirmationToken> getToken(String confirmationToken);
    int setConfirmedAt(String token);
}
