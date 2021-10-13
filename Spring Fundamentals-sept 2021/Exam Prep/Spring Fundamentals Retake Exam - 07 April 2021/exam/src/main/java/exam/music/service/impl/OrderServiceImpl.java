package exam.music.service.impl;

import exam.music.model.entity.Order;
import exam.music.model.service.OrderServiceModel;
import exam.music.model.service.UserServiceModel;
import exam.music.model.view.OrderViewModel;
import exam.music.model.view.UserViewModel;
import exam.music.repository.OrderRepository;
import exam.music.service.CategoryService;
import exam.music.service.OrderService;
import exam.music.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;
    private final CategoryService categoryService;
    private final UserService userService;

    public OrderServiceImpl(OrderRepository orderRepository, ModelMapper modelMapper, CategoryService categoryService, UserService userService) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
        this.userService = userService;
    }

    @Override
    public void add(OrderServiceModel model, UserServiceModel userViewModel) {
        Order order = modelMapper.map(model, Order.class);
        order.setCategory(this.categoryService.getByName(model.getCategory()));
        order.setEmployee(this.userService.getUser(modelMapper.map(userViewModel, UserServiceModel.class)));
        //  System.out.println();
        this.orderRepository.saveAndFlush(order);
    }

    @Override
    public List<OrderViewModel> getAll() {
        List<Order> all = this.orderRepository.findAll();
        List<OrderViewModel> collect = all.stream()
                .map(order -> {
                    OrderViewModel map = modelMapper.map(order, OrderViewModel.class);
                    map.setImageUrl( String.format("/images/%s.png", order.getCategory().getName().name().toLowerCase()));
                    map.setNeededTime(order.getCategory().getNeededTime());
                    map.setUserViewModel(modelMapper.map(order.getEmployee(),UserViewModel.class));
                    System.out.println();
                    return map;
                })
                .collect(Collectors.toList());

        return collect;
    }

    @Override
    public void delete(String id) {
        this.orderRepository.deleteById(id);
    }
}
