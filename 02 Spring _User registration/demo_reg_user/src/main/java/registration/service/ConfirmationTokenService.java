package registration.service;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import registration.entityUser.ConfirmationToken;
import registration.repository.ConfirmationTokenRepository;

@Service
@AllArgsConstructor
public class ConfirmationTokenService {

    @Autowired
    private final ConfirmationTokenRepository confirmationTokenRepository;

    public  void saveConfirmationToken(ConfirmationToken token){
        this.confirmationTokenRepository.save(token);
    }
}
