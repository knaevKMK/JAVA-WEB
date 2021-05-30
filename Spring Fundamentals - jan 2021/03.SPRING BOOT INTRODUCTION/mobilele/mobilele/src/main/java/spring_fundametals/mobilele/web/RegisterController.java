package spring_fundametals.mobilele.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/user")
public class RegisterController {

    @GetMapping("/register")
    public  String register(){

        return "auth-register";
    }
}
