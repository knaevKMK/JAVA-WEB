package com.exam2.exam2.web;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/app")
public class HomeController {

    @GetMapping("/")
    public String index(){
        return "index";
    }
}
