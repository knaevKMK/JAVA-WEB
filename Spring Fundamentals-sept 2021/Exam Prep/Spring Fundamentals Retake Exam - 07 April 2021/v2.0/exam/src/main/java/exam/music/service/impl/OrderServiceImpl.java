package exam.music.service.impl;

import exam.music.model.entity.Order;
import exam.music.model.service.OrderServiceModel;
import exam.music.model.service.UserServiceModel;
import exam.music.model.view.CategoryViewModel;
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
    private final UserService userService;
    private final CategoryService categoryService;

    public OrderServiceImpl(OrderRepository orderRepository, ModelMapper modelMapper, UserService userService, CategoryService categoryService) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public void add(OrderServiceModel orderServiceModel, UserServiceModel userServiceModel) {
        Order order = modelMapper.map(orderServiceModel, Order.class);
        order.setEmployee((this.userService.find(userServiceModel)));
        order.setCategory(this.categoryService.findByName(orderServiceModel.getCategory()));
        System.out.println();
        this.orderRepository.saveAndFlush(order);
    }

    @Override
    public List<OrderViewModel> findAll() {
        return this.orderRepository.findAll()
                .stream().map(order -> {
                    OrderViewModel _map = modelMapper.map(order, OrderViewModel.class);
                    _map.setUserViewModel(modelMapper.map(order.getEmployee(), UserViewModel.class));
                    _map.setCategory(modelMapper.map(order.getCategory(), CategoryViewModel.class));
                    _map.setImageUrl(String.format("/images/%s.png",order.getCategory().getName().name().toUpperCase()));
                    System.out.println();
                    return _map;
                })
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(String id) {
        this.orderRepository.deleteById(id);
    }
}
