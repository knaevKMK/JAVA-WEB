package com.shop.SuperMarket.web;


import com.shop.SuperMarket.model.binding.CategoryBindingModel;
import com.shop.SuperMarket.model.binding.HomeBindingModel;
import com.shop.SuperMarket.model.service.CategoryServiceModel;
import com.shop.SuperMarket.service.interfaces.CategoryService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/category")
@AllArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;


    @GetMapping("/add")
    public String addCategory(Model model) {

        if (!model.containsAttribute("categoryBindingModel")) {
            model.addAttribute("categoryBindingModel", new CategoryBindingModel());
        }
        return "addCategory";
    }

    @PostMapping("/add")
    public String addCategoryConfirmation(@Valid @ModelAttribute CategoryBindingModel categoryBindingModel,
                                          BindingResult bindingResult,
                                          RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("categoryBindingModel", categoryBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.categoryBindingModel", bindingResult);
            return "redirect:add";
        }

        CategoryServiceModel categoryServiceModel = modelMapper.map(categoryBindingModel, CategoryServiceModel.class);
        this.categoryService.addCategory(categoryServiceModel);

        //todo check exist same name
        HomeBindingModel homeBindingModel = new HomeBindingModel();
        homeBindingModel.setName("Successfully added category!");
        redirectAttributes.addFlashAttribute("homeBindingModel", homeBindingModel);
        redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.homeBindingModel", bindingResult);
        return "redirect:/";
    }
}
