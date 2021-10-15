package exam.music.web;

import exam.music.model.binding.UserLoginBindingModel;
import exam.music.model.binding.UserRegisterBindingModel;
import exam.music.model.service.UserServiceModel;
import exam.music.model.view.UserViewModel;
import exam.music.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/login")
    public String login(Model model) {



        if (!model.containsAttribute("userLoginBindingModel")) {

            model.addAttribute("userLoginBindingModel", new UserLoginBindingModel());
        }
        return "login";
    }

    @PostMapping("login")
    public String loginConfirm(@Valid @ModelAttribute("model") UserLoginBindingModel userLoginBindingModel,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes,
                               HttpSession session) {
        if (bindingResult.hasErrors()) {

            redirectAttributes.addFlashAttribute("userLoginBindingModel", userLoginBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel", bindingResult);

            return "redirect:/users/login";
        }
        UserServiceModel user = this.userService.FindByUsername(userLoginBindingModel);
        if (user==null){
            redirectAttributes.addFlashAttribute("notFound", true);
            return "redirect:/users/login";
        }
        if (!user.getPassword().equals(userLoginBindingModel.getPassword())) {
            redirectAttributes.addFlashAttribute("notFound", true);
            return "redirect:/users/login";
        }
        session.setAttribute("user", modelMapper.map(user, UserViewModel.class));
        return "redirect:/";
    }


    @GetMapping("/register")
    public String register(Model model) {
        if (!model.containsAttribute("userRegisterBindingModel")) {
            model.addAttribute("userRegisterBindingModel", new UserRegisterBindingModel());
        }
        return "register";
    }


    @PostMapping("register")
    public String registerConfirm(@Valid @ModelAttribute("userRegisterBindingModel")
                                          UserRegisterBindingModel userRegisterBindingModel,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()
                || !userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())) {
            redirectAttributes.addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel", bindingResult);
            return "redirect:register";
        }
        try {
            this.userService.add(modelMapper.map(userRegisterBindingModel, UserServiceModel.class));
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("NotFound", true);
            return "redirect:register";
        }

        return "redirect:login";
    }


    @GetMapping("/logout")
    public String logout(HttpSession session) {
//        if (session.getAttribute("user") == null) {
//            return "redirect:/users/login";
//        }
        session.invalidate();
        return "redirect:/";
    }
}
