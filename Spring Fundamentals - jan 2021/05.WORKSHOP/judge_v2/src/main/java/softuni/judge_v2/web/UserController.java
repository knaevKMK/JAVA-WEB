package softuni.judge_v2.web;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import softuni.judge_v2.model.binding.UserLoginBindingModel;
import softuni.judge_v2.model.binding.UserRegisterBindingModel;
import softuni.judge_v2.model.service.UserServiceModel;
import softuni.judge_v2.repository.UserRepository;
import softuni.judge_v2.service.interfaces.UserService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    @GetMapping("/login")
    public String login(Model model) {
//        System.out.println(model.asMap().toString());
//
        if (!model.containsAttribute("userLoginBindingModel")) {
            model.addAttribute("userLoginBindingModel", new UserLoginBindingModel());
            //return "redirect:login";

        }
        return "login";
    }

    @PostMapping("/login")
    public String loginConfirm(@Valid @ModelAttribute UserLoginBindingModel userLoginBindingModel,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes,
                               HttpSession httpSession) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userLoginBindingModel", userLoginBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel", bindingResult);
            return "redirect:login";
        }

        UserServiceModel userServiceModel = userService.findByUsernameAndPassword(userLoginBindingModel.getUsername(), userLoginBindingModel.getPassword());
        if (userServiceModel == null) {
            redirectAttributes.addFlashAttribute("userLoginBindingModel", userLoginBindingModel);
            redirectAttributes.addFlashAttribute("notFound", true);
            return "redirect:login";
        }
        //TODO save user in session
        httpSession.setAttribute("user", userServiceModel);
        return "redirect:/home";
    }

    @GetMapping("/register")
    public String register(Model model) {
        if (!model.containsAttribute("userRegisterBindingModel")) {
            model.addAttribute("userRegisterBindingModel", new UserRegisterBindingModel());
        }
        return "register";
    }

    @PostMapping("/register")
    public String registerConfirm(@Valid @ModelAttribute UserRegisterBindingModel userRegisterBindingModel,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()
                || !userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())) {
            redirectAttributes.addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel", bindingResult);

            return "redirect:register";
        }


        UserServiceModel userServiceModel = modelMapper.map(userRegisterBindingModel, UserServiceModel.class);
        userService.registerUser(userServiceModel);


        return "redirect:login";
    }
}
