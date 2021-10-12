package com.exam.examandery01.web;

import com.exam.examandery01.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
private  final ItemService itemService;

    public HomeController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/")
    public ModelAndView index(HttpSession session, ModelAndView modelAndView) {


        if (session.getAttribute("user") == null) {
           modelAndView.setViewName( "index");
        }else {
            modelAndView.addObject("items", this.itemService.getAll());
            modelAndView.setViewName("home");
        }
        return modelAndView;
    }
}
