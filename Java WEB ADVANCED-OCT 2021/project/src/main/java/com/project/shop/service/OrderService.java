package com.project.shop.service;

import com.project.shop.model.binding.BuyBindingModel;
import com.project.shop.model.binding.OrderBindingModel;
import com.project.shop.model.entity.Order;
import com.project.shop.model.view.OrderViewModel;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public interface OrderService {
    Order placeOrder(BuyBindingModel listing, String buyer);
    Optional<OrderViewModel> getOrderBuyId(UUID id);
    void seedColumns();



    UUID  confirmOrder(OrderBindingModel orderBindingModel, String username) throws IllegalAccessException;

    Collection<OrderViewModel> getMyOrders(String username, int page, int pcs);

    Collection<OrderViewModel> getPurchases(String username, int page, int pcs);
}
