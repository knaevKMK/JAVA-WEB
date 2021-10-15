package exam.music.web;

import exam.music.model.view.HeroViewModel;
import exam.music.service.HeroService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HomeController {
private final HeroService heroService;
private final ModelMapper modelMapper;

    public HomeController(HeroService heroService, ModelMapper modelMapper) {
        this.heroService = heroService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/")
    public ModelAndView home(ModelAndView modelAndView,HttpSession session){
        if (session.getAttribute("user")==null){
            modelAndView.setViewName("index");
        }else {

          List<HeroViewModel> heroes= this.heroService.findAll();
            modelAndView.addObject("heroes",heroes);
            modelAndView.setViewName("home");
        }
        return  modelAndView;
    }
}
