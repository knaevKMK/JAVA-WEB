package com.shop.SuperMarket.web;


import com.shop.SuperMarket.model.binding.HomeBindingModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
@AllArgsConstructor
public class HomeController {

    //todo ADD the choose option in path link

    @GetMapping("/")
    public String homeMenu(Model model) {

        if (!model.containsAttribute("homeBindingModel")) {
            model.addAttribute("homeBindingModel", new HomeBindingModel());
        }
        return "home";
    }


//    @PostMapping("/2")
//    public String addTown() {
//        //TODO add category
//        return "home";
//    }
//
//    @PostMapping("/3")
//    public String addShop() {
//        //TODO add category
//        return "home";
//    }
//
//    @PostMapping("/4")
//    public String addSeller() {
//        //TODO add category
//        return "home";
//    }
//
//    @PostMapping("/5")
//    public String addProduct() {
//        //TODO add category
//        return "home";
//    }
//
//    @PutMapping("/6")
//    public String setManager() {
//        //TODO
//        return "home";
//    }
//
//    @PutMapping("/7")
//    public String distributeProducts(){
//        //TODO
//        return "home";
//    }
//
//    @GetMapping("/8")
//    public String showAllSellersInShop(){
// //TODO and create template;
//
//        return "sellers";
//    }
//
//    @GetMapping("/9")
//    public String showAllProductsInShop(){
//        //TODO and create template;
//
//        return "products";
//    }
}
