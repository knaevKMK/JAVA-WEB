package com.exam.prepare.web;


import com.exam.prepare.service.ProductService;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Component
@RequestMapping("/app")
public class HomeController {

    private final ProductService productService;

    public HomeController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String index(HttpSession session, Model model) {
        if (session.getAttribute("user") == null) {
            return "index";
        }
       //model.addAttribute("totalSum", this.productService.totalPrice());
        return "home";
    }


}
