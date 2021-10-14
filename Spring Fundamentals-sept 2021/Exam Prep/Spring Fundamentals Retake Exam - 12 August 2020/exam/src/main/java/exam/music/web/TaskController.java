package exam.music.web;

import exam.music.model.binding.TaskAddBindingModel;
import exam.music.model.entity.ProgressEnum;
import exam.music.model.entity.Task;
import exam.music.model.service.TaskServiceModel;
import exam.music.model.service.UserServiceModel;
import exam.music.model.view.UserViewModel;
import exam.music.service.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/tasks")
public class TaskController {
    private final ModelMapper modelMapper;
    private final TaskService taskService;

    public TaskController(ModelMapper modelMapper, TaskService taskService) {
        this.modelMapper = modelMapper;
        this.taskService = taskService;
    }

    @GetMapping("/add")
    public String add(Model model, HttpSession session) {

        if (session.getAttribute("user") == null) {
            return "redirect:/users/login";
        }
        if (!model.containsAttribute("taskAddBindingModel")) {
            model.addAttribute("taskAddBindingModel", new TaskAddBindingModel());
        }
        return "add-task";
    }

    @PostMapping("add")
    public String addConfirm(@Valid @ModelAttribute("taskAddBindingModel") TaskAddBindingModel taskAddBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes,
                             HttpSession session) {


        if (session.getAttribute("user") == null) {
            return "redirect:/users/login";
        }
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("taskAddBindingModel", taskAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.taskAddBindingModel", bindingResult);
            return "add-task";
        }
        this.taskService.add(modelMapper.map(taskAddBindingModel, TaskServiceModel.class)
                , modelMapper.map((UserViewModel) session.getAttribute("user"), UserServiceModel.class));

        return "redirect:/";
    }

    @GetMapping("/progress")
    public String progress(@RequestParam("id") String id, HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/users/login";
        }
        Optional<Task> task = taskService.getTaskById(id);
        if (!task.isPresent()) {
            return "redirect:/";
        }
        Task _task = task.get();
        switch (_task.getProgress().name()) {
            case "OPEN":
                _task.setProgress(ProgressEnum.IN_PROGRESS);
                this.taskService.update(_task);
                break;
            case "IN_PROGRESS":
                _task.setProgress(ProgressEnum.COMPLETED);
                this.taskService.update(_task);
                break;
            case "COMPLETED":
                this.taskService.delete(id);
                break;

        }
        return "redirect:/";
    }
}
