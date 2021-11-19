package com.project.shop.model.view;

import java.math.BigDecimal;
import java.util.List;

public class DeliveryViewModel {

    private List<String> deliveryService;


    public DeliveryViewModel() {
    }



    public List<String> getDeliveryService() {
        return deliveryService;
    }

    public DeliveryViewModel setDeliveryService(List<String> deliveryService) {
        this.deliveryService = deliveryService;
        return this;
    }


}
