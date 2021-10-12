package com.exam.examandery01.web;


import com.exam.examandery01.model.binding.ItemAddBindingModel;
import com.exam.examandery01.model.services.ItemServiceModel;
import com.exam.examandery01.service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;
    private final ModelMapper modelMapper;

    public ItemController(ItemService itemService, ModelMapper modelMapper) {
        this.itemService = itemService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String add() {

        return "add-item";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid @ModelAttribute("model") ItemAddBindingModel model,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes,
                             HttpSession session  ) {
        if (session.getAttribute("user") == null) {
            return "redirect:/users/login";
        }

        if (bindingResult.hasErrors()) {
            return "redirect:add";
        }
String id=    this.itemService.add(modelMapper.map(model, ItemServiceModel.class));
        return "redirect:/items/" + id;
    }

    @GetMapping("/details/{id}")
    public String details(String id) {
        if (id == null) {

            return "redirect:home";
        }
        return "details-item";
    }

    @GetMapping("/all")
    public String all() {

        return "home";
    }
}
