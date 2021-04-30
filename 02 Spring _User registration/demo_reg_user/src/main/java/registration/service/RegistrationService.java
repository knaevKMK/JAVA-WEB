package registration.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import registration.entityUser.AppUser;
import registration.entityUser.AppUserRole;
import registration.entityUser.RegistrationRequest;
import registration.validator.EmailValidator;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final AppUserService appUserService;
    private final EmailValidator emailValidator;

    public String register(RegistrationRequest registrationRequest) {
        boolean isValidEmail = emailValidator.test(registrationRequest.getEmail());

        if (!isValidEmail) {
            throw new IllegalArgumentException("Invalid email");
        }
        return appUserService.signUpUser(new AppUser(
                registrationRequest.getFirstName(),
                registrationRequest.getLastName(),
                registrationRequest.getUsername(),
                registrationRequest.getEmail(),
                registrationRequest.getPassword(),
                AppUserRole.USER
        ));

    }
}
