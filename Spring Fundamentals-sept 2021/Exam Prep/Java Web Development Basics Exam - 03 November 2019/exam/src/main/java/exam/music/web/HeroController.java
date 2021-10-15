package exam.music.web;

import exam.music.model.binding.HeroAddBindingModel;
import exam.music.model.service.HeroServiceModel;
import exam.music.model.view.HeroViewModel;
import exam.music.service.HeroService;
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
@RequestMapping("/heroes")
public class HeroController {

    private final ModelMapper modelMapper;
    private final HeroService heroService;

    public HeroController(ModelMapper modelMapper, HeroService heroService) {
        this.modelMapper = modelMapper;
        this.heroService = heroService;
    }

    @GetMapping("/create")
    public String add(Model model, HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/users/login";
        }
        if (!model.containsAttribute("heroAddBindingModel")) {
            model.addAttribute("heroAddBindingModel", new HeroAddBindingModel());
        }

        return "create-hero";
    }

    @PostMapping("/create")
    public String addConfirm(@Valid @ModelAttribute("heroAddBindingModel") HeroAddBindingModel heroAddBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes,
                             HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/users/login";
        }
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("heroAddBindingModel", heroAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.heroAddBindingModel", bindingResult);
            return "redirect:create";
        }
        String id = this.heroService.add(modelMapper.map(heroAddBindingModel, HeroServiceModel.class));


        return "redirect:/";
    }

    @GetMapping("/details")
    public ModelAndView details(@RequestParam("id") String id, ModelAndView modelAndView, HttpSession session) {

        HeroViewModel heroViewModel = modelMapper.map(this.heroService.findById(id), HeroViewModel.class);
        if (heroViewModel == null) {
            modelAndView.setViewName("home");
        } else {
            modelAndView.addObject("hero", heroViewModel);
            modelAndView.setViewName("details-hero");
        }

        return modelAndView;
    }

    @GetMapping("/delete")
    public ModelAndView delete(@RequestParam("id") String id, ModelAndView modelAndView, HttpSession session) {

        HeroViewModel heroViewModel = modelMapper.map(this.heroService.findById(id), HeroViewModel.class);
        if (heroViewModel == null) {
            modelAndView.setViewName("home");
        } else {
            modelAndView.addObject("hero", heroViewModel);
            modelAndView.setViewName("delete-hero");
        }

        return modelAndView;
    }

    @GetMapping("/deleteConfirm")
    public String deleteConfirm(@RequestParam("id") String id, HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/users/login";
        }
        this.heroService.delete(id);
        return "redirect:/";
    }
}
