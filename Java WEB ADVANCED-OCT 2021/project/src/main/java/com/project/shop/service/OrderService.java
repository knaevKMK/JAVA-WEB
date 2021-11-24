package com.project.shop.service;

import com.project.shop.model.binding.BuyBindingModel;
import com.project.shop.model.entity.Account;
import com.project.shop.model.entity.Listing;
import com.project.shop.model.entity.Order;

import java.util.Optional;
import java.util.UUID;

public interface OrderService {
    Order placeOrder(BuyBindingModel listing, Listing listing1, Account buyer);
    Optional<Order> getOrderBuyId(UUID id);
    void seedColumns();
}
