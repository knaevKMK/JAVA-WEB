package com.shop.SuperMarket.web;


import com.shop.SuperMarket.model.binding.HomeBindingModel;
import com.shop.SuperMarket.model.binding.TownBindingModel;
import com.shop.SuperMarket.model.service.TownServiceModel;
import com.shop.SuperMarket.service.interfaces.TownService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
@RequestMapping("/town")
public class TownController {

    private final TownService townService;
    private final ModelMapper modelMapper;

    @GetMapping("/add")
    public String addTown(Model model) {

        if (!model.containsAttribute("townBindingModel")) {
            model.addAttribute("townBindingModel", new TownBindingModel());
        }
        return "addTown";
    }

    @PostMapping("/add")
    public String addTownConfirmation(@Valid @ModelAttribute TownBindingModel townBindingModel,
                                      BindingResult bindingResult,
                                      RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("townBindingModel", townBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.townBindingModel", bindingResult);
            return "redirect:add";
        }

        TownServiceModel townServiceModel = modelMapper.map(townBindingModel, TownServiceModel.class);
        this.townService.addTown(townServiceModel);

        HomeBindingModel homeBindingModel = new HomeBindingModel();
        homeBindingModel.setName("Successfully added town!");
        redirectAttributes.addFlashAttribute("homeBindingModel", homeBindingModel);
        return "redirect:/";
    }

}
