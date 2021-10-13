package exam.music.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
// todo add List<EntityViewModel> from EntityService
    @GetMapping("/")
    public ModelAndView home(ModelAndView modelAndView,HttpSession session){
        if (session.getAttribute("user")==null){
            modelAndView.setViewName("index");
        }else {
            modelAndView.setViewName("home");
        }
        return  modelAndView;
    }
}
