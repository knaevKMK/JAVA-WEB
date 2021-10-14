package exam.music.service.impl;

import exam.music.model.entity.ProgressEnum;
import exam.music.model.entity.Task;
import exam.music.model.service.TaskServiceModel;
import exam.music.model.service.UserServiceModel;
import exam.music.model.view.TaskViewModel;
import exam.music.repository.TaskRepository;
import exam.music.service.ClassificationService;
import exam.music.service.TaskService;
import exam.music.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final ModelMapper modelMapper;
    private final ClassificationService classificationService;
    private final UserService userService;

    public TaskServiceImpl(TaskRepository taskRepository, ModelMapper modelMapper, ClassificationService classificationService, UserService userService) {
        this.taskRepository = taskRepository;
        this.modelMapper = modelMapper;
        this.classificationService = classificationService;
        this.userService = userService;
    }


    @Override
    public void delete(String id) {
        this.taskRepository.deleteById(id);
    }

    @Override
    public void add(TaskServiceModel model, UserServiceModel userServiceModel) {
        Task task = modelMapper.map(model, Task.class);
        task.setProgress(ProgressEnum.OPEN);
        task.setClassification(this.classificationService.getByName(model.getClassification()));
        task.setUser(this.userService.getUser(userServiceModel));
        System.out.println();
        this.taskRepository.saveAndFlush(task);
    }

    @Override
    public List<TaskViewModel> getAll() {
        return taskRepository.findAll().stream().map(task -> {
            TaskViewModel map = modelMapper.map(task, TaskViewModel.class);
            map.setAssignTo(task.getUser().getUsername());
            map.setClassification(task.getClassification().getClassificationName().name());
            map.setProgress(task.getProgress().name());
            return map;
        })
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Task> getTaskById(String id) {
        Optional<Task> _task = this.taskRepository.findById(id);
        return _task;
    }

    @Override
    public void update(Task task) {
        this.taskRepository.saveAndFlush(task);
    }
}
