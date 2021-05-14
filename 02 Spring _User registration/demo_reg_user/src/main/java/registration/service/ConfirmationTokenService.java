package registration.service;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import registration.entityUser.ConfirmationToken;
import registration.repository.ConfirmationTokenRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ConfirmationTokenService {

    @Autowired
    private final ConfirmationTokenRepository confirmationTokenRepository;

    public  void saveConfirmationToken(ConfirmationToken token){
        this.confirmationTokenRepository.save(token);
    }
    public Optional<ConfirmationToken> getToken(String confirmationToken){
        return this.confirmationTokenRepository.findByToken(confirmationToken);
    }

    public int setConfirmedAt(String token) {
        return confirmationTokenRepository.updateConfirmedAt(
                token, LocalDateTime.now());
    }
}
