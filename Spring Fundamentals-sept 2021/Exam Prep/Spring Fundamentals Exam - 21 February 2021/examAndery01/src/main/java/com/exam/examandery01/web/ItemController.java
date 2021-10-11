package com.exam.examandery01.web;


import com.exam.examandery01.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/items")
public class ItemController {

    private  final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping ("/add")
    public String add(){

        return "add-item";
    }
    @PostMapping("/add")
    public String addConfirm(){

        return "redirect:/items/" + 1;
    }
    @GetMapping ("/details/{id}")
    public String details(String id){
if (id.equals(null)){

    return "redirect:home";
}
        return "details-item";
    }
    @GetMapping("/all")
    public  String all(){

        return "home";
    }
}
