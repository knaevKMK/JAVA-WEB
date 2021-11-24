package com.project.shop.service.impl;

import com.project.shop.model.binding.BuyBindingModel;
import com.project.shop.model.entity.Account;
import com.project.shop.model.entity.Listing;
import com.project.shop.model.entity.Order;
import com.project.shop.repository.OrderRepository;
import com.project.shop.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderServiceImpl extends BaseServiceImpl<Order> implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order placeOrder(BuyBindingModel buyModel, Listing listing, Account buyer) {
        Order order = new Order();
        order.setQuantity(buyModel.getQuantity())
                .setPrice(buyModel.getPrice())
                .setBuyer(buyer)
                .setListings(List.of(listing));
        order = this.onCreate(order, buyer.getUsername());
        Order order1 = orderRepository.saveAndFlush(order);
        return order1;
    }

    @Override
    public Optional<Order> getOrderBuyId(UUID id) {
        return Optional.empty();
    }

    @Override
    public void seedColumns() {
        orderRepository.addPriceColumn();
        orderRepository.addQuantityColumn();
    }
}
