package com.project.shop.service;


import com.project.shop.model.binding.DeliveryBindingModel;
import com.project.shop.model.entity.DeliveryOptions;

public interface DeliveryService {
    void seedData();

    DeliveryOptions create(DeliveryBindingModel deliveryOptions);
}
