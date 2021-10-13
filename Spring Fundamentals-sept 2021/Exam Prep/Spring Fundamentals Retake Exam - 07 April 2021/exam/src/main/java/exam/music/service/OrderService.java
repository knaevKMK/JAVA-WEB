package exam.music.service;

import exam.music.model.service.OrderServiceModel;
import exam.music.model.service.UserServiceModel;
import exam.music.model.view.OrderViewModel;
import exam.music.model.view.UserViewModel;

import java.util.List;

public interface OrderService {
    void add(OrderServiceModel model, UserServiceModel userServiceModel );

    List<OrderViewModel> getAll();

    void delete(String id);
}
