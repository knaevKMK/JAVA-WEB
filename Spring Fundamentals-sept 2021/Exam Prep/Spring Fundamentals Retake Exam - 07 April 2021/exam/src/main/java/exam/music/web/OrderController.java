package exam.music.web;

import exam.music.model.binding.OrderAddBindingModel;
import exam.music.model.service.OrderServiceModel;
import exam.music.model.service.UserServiceModel;
import exam.music.model.view.UserViewModel;
import exam.music.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/orders/")
public class OrderController {
    private final OrderService orderService;
    private final ModelMapper modelMapper;

    public OrderController(OrderService orderService, ModelMapper modelMapper) {
        this.orderService = orderService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String add(Model model, HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/users/login";
        }
        if (!model.containsAttribute("orderAddBindingModel")) {
            model.addAttribute("orderAddBindingModel", new OrderAddBindingModel());
        }
        return "order-add";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid @ModelAttribute("orderAddBindingModel") OrderAddBindingModel orderAddBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes,
                             HttpSession session) {

        if (session.getAttribute("user") == null) {
            return "redirect:/users/login";
        }
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("orderAddBindingModel", orderAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.orderAddBindingModel", bindingResult);
            return "order-add";
        }
        this.orderService.add(modelMapper.map(orderAddBindingModel, OrderServiceModel.class)
                , modelMapper.map((UserViewModel) session.getAttribute("user"), UserServiceModel.class));
        return "redirect:/";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("id") String id, HttpSession session){
        if (session.getAttribute("user") == null) {
            return "redirect:/users/login";
        }
        this.orderService.delete(id);
        return "redirect:/";
    }

}
