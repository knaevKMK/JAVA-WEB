package exam.music.web;

import exam.music.model.view.ProductViewModel;
import exam.music.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {
    private final ProductService productService;

    public HomeController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public ModelAndView home(ModelAndView modelAndView, HttpSession session) {
        if (session.getAttribute("user") == null) {
            modelAndView.setViewName("index");
        } else {
            List<ProductViewModel> all = this.productService.getAll();

            List<ProductViewModel> food = all.stream().filter(p -> p.getCategory().equals("FOOD")).collect(Collectors.toList());
            List<ProductViewModel> drink = all.stream().filter(p -> p.getCategory().equals("DRINK")).collect(Collectors.toList());
            List<ProductViewModel> houseland = all.stream().filter(p -> p.getCategory().equals("HOUSELAND")).collect(Collectors.toList());
            List<ProductViewModel> other = all.stream().filter(p -> p.getCategory().equals("OTHER")).collect(Collectors.toList());

            BigDecimal totalSum = new BigDecimal(all.stream().mapToDouble(e -> Double.parseDouble(e.getPrice().toString())).sum());
            modelAndView.addObject("foods", food);
            modelAndView.addObject("drinks", drink);
            modelAndView.addObject("households", houseland);
            modelAndView.addObject("other", other);
            modelAndView.addObject("totalSum", totalSum);


            modelAndView.setViewName("home");
        }
        return modelAndView;
    }
}
