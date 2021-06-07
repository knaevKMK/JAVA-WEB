package spring_fundametals.mobilele.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {


    @GetMapping("/users/login")
    public String login(){

        return "auth-login";
    }

//    @PostMapping("/login")
//    public String loginConfirm(){
//
//        return "redirect:/";
//    }


}
