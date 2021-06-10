package com.exam.prepare.web;


import com.exam.prepare.model.binding.ProductBindingModel;
import com.exam.prepare.model.service.ProductServiceModel;
import com.exam.prepare.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;
    private final ModelMapper modelMapper;

    public ProductController(ProductService productService, ModelMapper modelMapper) {
        this.productService = productService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String addProduct(Model model) {
        if(!model.containsAttribute("productBindingModel")){
            model.addAttribute("productBindingModel", new ProductBindingModel());
        }
        return "product-add";
    }

    @PostMapping("add")
    public String addProductConfirm(@Valid ProductBindingModel productBindingModel,
                                    BindingResult bindingResult,
                                    RedirectAttributes redirectAttributes,
                                    HttpSession httpSession) {
        if (httpSession.getAttribute("user") == null) {
            return "redirect:/users/login";
        }
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("productBindingModel", productBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.productBindingModel", bindingResult);
            return "product-add";
        }
        System.out.println(productBindingModel.toString());
     this.productService.addProduct(modelMapper.map(productBindingModel, ProductServiceModel.class));

        return "redirect:/app/";
    }
}
