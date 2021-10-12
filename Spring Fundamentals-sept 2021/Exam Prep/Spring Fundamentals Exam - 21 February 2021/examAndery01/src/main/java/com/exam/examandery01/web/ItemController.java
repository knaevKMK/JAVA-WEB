package com.exam.examandery01.web;

import com.exam.examandery01.model.binding.ItemAddBindingModel;
import com.exam.examandery01.model.services.ItemServiceModel;
import com.exam.examandery01.model.view.ItemViewModel;
import com.exam.examandery01.service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
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
    public String add(Model model, HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/users/login";
        }

        if (!model.containsAttribute("itemAddBindingModel")){
            model.addAttribute("itemAddBindingModel",new ItemAddBindingModel());
        }
        return "add-item";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid @ModelAttribute("itemAddBindingModel") ItemAddBindingModel itemAddBindingModel,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes,
                             HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/users/login";
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("itemAddBindingModel",itemAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.itemAddBindingModel", bindingResult);

            return "redirect:add";
        }
        String id = this.itemService.add(modelMapper.map(itemAddBindingModel, ItemServiceModel.class));
        return "redirect:/items/details/?id=" + id;
    }

    @GetMapping("/details")
    public ModelAndView details(@RequestParam("id") String id, ModelAndView modelAndView,HttpSession session) {
        if (session.getAttribute("user") == null) {
           modelAndView.setViewName("login");
        }
        if (id == null) {
            modelAndView.setViewName("home");
        } else {
            ItemViewModel viewModel = this.itemService.GetItemById(id);
            if (viewModel != null) {
                modelAndView.addObject("item", viewModel);
                modelAndView.setViewName("details-item");
            }
        }


        return modelAndView;
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") String id, HttpSession session) {
        if (session.getAttribute("user")!=null){
        this.itemService.delete(id);
        }
        return "redirect:/";
    }

}
