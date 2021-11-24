package com.project.shop.infrastructure.identity.service.impl;

import com.project.shop.infrastructure.identity.models.entity.ConfirmationToken;
import com.project.shop.infrastructure.identity.repository.ConfirmationTokenRepository;
import com.project.shop.infrastructure.identity.service.ConfirmationTokenService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ConfirmationTokenServiceImpl implements ConfirmationTokenService {
    private final ConfirmationTokenRepository confirmationTokenRepository;

    public ConfirmationTokenServiceImpl(ConfirmationTokenRepository confirmationTokenRepository) {
        this.confirmationTokenRepository = confirmationTokenRepository;
    }

    @Override
    public ConfirmationToken saveConfirmationToken(ConfirmationToken confirmationToken) {
       return this.confirmationTokenRepository.save(confirmationToken);
    }
    @Override
    public Optional<ConfirmationToken> getToken(String confirmationToken){
        return this.confirmationTokenRepository.findByToken(confirmationToken);
    }
    @Override
    public int setConfirmedAt(String token) {
        return confirmationTokenRepository.updateConfirmedAt(
                token, LocalDateTime.now());
    }
}
