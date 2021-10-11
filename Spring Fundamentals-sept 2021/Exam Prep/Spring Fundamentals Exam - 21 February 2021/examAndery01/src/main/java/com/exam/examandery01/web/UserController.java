package com.exam.examandery01.web;


import com.exam.examandery01.model.binding.UserLoginBindingModel;
import com.exam.examandery01.model.binding.UserRegisterBindingModel;
import com.exam.examandery01.model.entity.User;
import com.exam.examandery01.model.services.UserServiceModel;
import com.exam.examandery01.service.UserService;
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
    public String login() {
// todo binding
        return "login";
    }

    @PostMapping("/login")
    public String loginConfirm(@Valid @ModelAttribute("model") UserLoginBindingModel model,
                               BindingResult bindingResult, RedirectAttributes redirectAttributes, HttpSession session) {
        if (!bindingResult.hasErrors()) {


        //    return "redirect:login";
        }
        UserServiceModel user = this.userService.FindByUsername(model);
        if (!user.getPassword().equals(model.getPassword())) {
            redirectAttributes.addFlashAttribute("notFound", true);
            return "redirect:login";
        }
        session.setAttribute("user", user);
        return "home";
    }

    @GetMapping("/register")
    public String register(Model model) {
        if (!model.containsAttribute("userRegisterBindingModel")) {
            //     model.addAllAttributes("userRegisterBindingModel",)
        }
        return "register";
    }

    @PostMapping("/register")
    public String registerConfirm(@Valid @ModelAttribute("userRegisterBindingModel")
                                          UserRegisterBindingModel userRegisterBindingModel,
                                  BindingResult bindingResult, RedirectAttributes redirectAttributes
    ) {

        if (bindingResult.hasErrors()
                || !userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())) {

            return "redirect:register";
        }
        try {
            this.userService.add(modelMapper.map(userRegisterBindingModel, UserServiceModel.class));
        } catch (Exception e) {
            return "redirect:register";
        }

        return "redirect:login";
    }


    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
