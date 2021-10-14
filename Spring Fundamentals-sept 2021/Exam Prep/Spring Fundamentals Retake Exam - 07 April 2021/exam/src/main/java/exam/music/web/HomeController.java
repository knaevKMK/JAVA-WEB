package exam.music.web;

import exam.music.model.view.OrderViewModel;
import exam.music.model.view.UserViewModel;
import exam.music.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class HomeController {
    private final OrderService orderService;

    public HomeController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/")
    public ModelAndView home(ModelAndView modelAndView, HttpSession session) {
        if (session.getAttribute("user") == null) {
            modelAndView.setViewName("index");
        } else {

            List<OrderViewModel> all = this.orderService.getAll();
            modelAndView.addObject("all", all);
            int totalTime = all.stream().mapToInt(e -> e.getNeededTime()).sum();
            modelAndView.addObject("totalTime", totalTime);

            List<UserViewModel> users = all.stream().map(e -> {
                UserViewModel userViewModel = e.getUserViewModel();
                userViewModel.setOrders((int) all.stream().filter(o->o.getUserViewModel().getUsername()== userViewModel.getUsername()).count());
                return userViewModel;
            }).collect(Collectors.toList());

            modelAndView.addObject("users", users);
            modelAndView.setViewName("home");
        }
        return modelAndView;
    }
}
