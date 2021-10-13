package exam.music.web;

import exam.music.model.view.AlbumViewModel;
import exam.music.service.AlbumService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {
private final AlbumService albumService;

    public HomeController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping("/")
    public ModelAndView home(ModelAndView modelAndView,HttpSession session){
        if (session.getAttribute("user")==null){
            modelAndView.setViewName("index");
        }else {
            List<AlbumViewModel> all = this.albumService.getAll();
            int sum = all.stream().mapToInt(e -> Integer.parseInt(String.valueOf(e.getCopies()))).sum();
            modelAndView.addObject("count", sum );
            modelAndView.addObject("all",all);
            modelAndView.setViewName("home");
        }
        return  modelAndView;
    }
}
