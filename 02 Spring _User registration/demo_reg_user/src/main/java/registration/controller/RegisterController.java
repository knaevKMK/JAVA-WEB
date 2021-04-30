package registration.controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import registration.entityUser.RegistrationRequest;
import registration.service.RegistrationService;

@RestController
@RequestMapping("/app/v1")
@AllArgsConstructor
public class RegisterController {

    private final RegistrationService registrationService;

    @PostMapping("/registration")
    public String registration(@RequestBody RegistrationRequest registrationRequest){
        return this.registrationService.register(registrationRequest);
    }
}
