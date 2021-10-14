package exam.music.service;

import exam.music.model.entity.Task;
import exam.music.model.service.TaskServiceModel;
import exam.music.model.service.UserServiceModel;
import exam.music.model.view.TaskViewModel;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    void delete(String id);

    void add(TaskServiceModel model, UserServiceModel userServiceModel);

    List<TaskViewModel> getAll();

    Optional<Task> getTaskById(String id);

    void update(Task task);
}
