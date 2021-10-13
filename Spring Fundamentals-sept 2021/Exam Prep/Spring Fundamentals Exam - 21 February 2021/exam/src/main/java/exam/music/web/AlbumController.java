package exam.music.web;

import exam.music.model.binding.AlbumAddBindingModel;
import exam.music.model.service.AlbumServiceModel;
import exam.music.model.service.UserServiceModel;
import exam.music.service.AlbumService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/albums")
public class AlbumController {


    private final AlbumService albumService;
    private final ModelMapper modelMapper;

    public AlbumController(AlbumService albumService, ModelMapper modelMapper) {
        this.albumService = albumService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String add(Model model, HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/users/login";
        }
        if (!model.containsAttribute("albumAddBindingModel")) {
            model.addAttribute("albumAddBindingModel", new AlbumAddBindingModel());
        }
        return "add-album";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid @ModelAttribute("albumAddBindingModel") AlbumAddBindingModel albumAddBindingModel
            , BindingResult bindingResult, RedirectAttributes redirectAttributes, HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/users/login";
        }
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("albumAddBindingModel", albumAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.albumAddBindingModel", bindingResult);
            return "add-album";
        }
        this.albumService.add(modelMapper.map(albumAddBindingModel, AlbumServiceModel.class), modelMapper.map(session.getAttribute("user"),UserServiceModel.class));
        return "redirect:/";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("id") String id, HttpSession session){
        if (session.getAttribute("user")!=null){
            this.albumService.delete(id);
        }
        return  "redirect:/";
    }
}
