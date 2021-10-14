package exam.music.web;

import exam.music.model.binding.ProductBindingModel;
import exam.music.model.service.ProductServiceModel;
import exam.music.model.service.UserServiceModel;
import exam.music.model.view.UserViewModel;
import exam.music.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/products")
public class ProductController {


    private final ModelMapper modelMapper;
    private final ProductService productService;

    public ProductController(ModelMapper modelMapper, ProductService productService) {
        this.modelMapper = modelMapper;
        this.productService = productService;
    }

    @GetMapping("/add")
    public String add(Model model, HttpSession session){
        if (session.getAttribute("user") == null) {
            return "redirect:/users/login";
        }
        if (!model.containsAttribute("productBindingModel")) {
            model.addAttribute("productBindingModel", new ProductBindingModel());
        }
        return "product-add";
    }
    @PostMapping("/add")
    public String addConfirm(@Valid @ModelAttribute("productBindingModel") ProductBindingModel productBindingModel,
                      BindingResult bindingResult,
                      RedirectAttributes redirectAttributes,
                      HttpSession session){
        if (session.getAttribute("user") == null) {
            return "redirect:/users/login";
        }
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("productBindingModel", productBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.productBindingModel", bindingResult);
            return "product-add";
        }
        this.productService.add(modelMapper.map(productBindingModel, ProductServiceModel.class));

        return "redirect:/";
    }
    @GetMapping("/buy")
    public  String buy(@RequestParam("id") String id, HttpSession session){

        if (session.getAttribute("user") == null) {
            return "redirect:/users/login";
        }
        this.productService.delete(id);

        return "redirect:/";
    }
    @GetMapping("/buyAll")
    public  String buyAll( HttpSession session){

        if (session.getAttribute("user") == null) {
            return "redirect:/users/login";
        }
        this.productService.deleteAll();

        return "redirect:/";
    }
}
