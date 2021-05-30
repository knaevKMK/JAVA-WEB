package com.stateManagment.cookieOrSession.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class LangController {

    private static final String defaultLang = "en";
    private List<String> languages = List.of("bg", "en", "de");

    @GetMapping("/all")
    public String allLangs(Model model,
                           //   @CookieValue(value = "langCookie", required = false, defaultValue = defaultLang)  String lang) {
                           HttpSession session) {

        Object preferredLang = session.getAttribute("lang");
        if (preferredLang == null) {
            preferredLang = defaultLang;
        }
        model.addAttribute("all", languages);
//        model.addAttribute("preferredLang", lang);
        model.addAttribute("preferredLang", preferredLang);
        return "lang";
    }

    @PostMapping("/save")
    public String save(@RequestParam String lang,
                       HttpServletResponse response,
                       HttpSession session) {
//        Cookie cookie = new Cookie("langCookie", lang);
//        response.addCookie(cookie);

        session.setAttribute("lang", lang);
        return "redirect:/all";
    }

}
