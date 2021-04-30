package registration.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import registration.entityUser.AppUser;
import registration.entityUser.ConfirmationToken;
import registration.repository.AppUserRepository;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {
    private static final String ERR_MSG_USER_NOT_FOUND = "User with email: %s does not exist!";

    private final AppUserRepository appUserRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return appUserRepository.findAppUserByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format(ERR_MSG_USER_NOT_FOUND, email)));
    }

    public String signUpUser(AppUser appUser) {
        boolean userExist = this.appUserRepository.findAppUserByEmail(appUser.getEmail()).isPresent();
        if (userExist) {
            throw new IllegalStateException("email already taken");
        }

        appUser.setPassword(bCryptPasswordEncoder.encode(appUser.getPassword()));
        this.appUserRepository.save(appUser);

        String token = String.valueOf(UUID.randomUUID());
        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                appUser);

        this.confirmationTokenService
                .saveConfirmationToken(confirmationToken);

        //TODO send email
        return token;
    }
}
