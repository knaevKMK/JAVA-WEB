package com.MusicDbApp.demo.web;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Component
@RequestMapping("/app")
public class HomeController {


    @GetMapping("/")
    public String index(HttpSession session, Model model) {
        if (session.getAttribute("user") == null) {
            return "index";
        }
        //model.addAttribute("totalSum", this.productService.totalPrice());
        return "home";
    }
}
