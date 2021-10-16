package exam.music.service;

import exam.music.model.service.OrderServiceModel;
import exam.music.model.service.UserServiceModel;
import exam.music.model.view.OrderViewModel;

import java.util.List;

public interface OrderService {
    void add(OrderServiceModel orderServiceModel, UserServiceModel userServiceModel);

    List<OrderViewModel> findAll();

    void deleteById(String id);
}
