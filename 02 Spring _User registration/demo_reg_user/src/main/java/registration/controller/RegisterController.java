package registration.controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import registration.service.AppUserService;
import registration.service.RegistrationRequest;
import registration.service.RegistrationService;

@RestController
@RequestMapping("/app/v1/registration")
@AllArgsConstructor
public class RegisterController {

    private final RegistrationService registrationService;

    @PostMapping("/")
    public String registration(@RequestBody RegistrationRequest registrationRequest){
        return this.registrationService.register(registrationRequest);
    }
}
