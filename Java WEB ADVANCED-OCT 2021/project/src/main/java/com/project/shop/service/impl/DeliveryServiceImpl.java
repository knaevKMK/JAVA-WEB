package com.project.shop.service.impl;

import com.project.shop.repository.impl.BaseRepositoryImpl;
import com.project.shop.model.entity.DeliveryOptions;
import com.project.shop.model.enums.DeliveryServiceEnum;
import com.project.shop.repository.DeliveryRepository;
import com.project.shop.service.DeliveryService;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeliveryServiceImpl extends BaseRepositoryImpl<DeliveryOptions> implements DeliveryService {
    private final DeliveryRepository deliveryRepository;

    public DeliveryServiceImpl(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    @Override
    public void seedData() {
        if (deliveryRepository.count()!=0){return;}
        List<DeliveryOptions> deliveryOptions = Arrays.stream(DeliveryServiceEnum.values())
                .map(deliveryEnum -> {
                    DeliveryOptions delivery = new DeliveryOptions();
                    delivery
                            .setDeliveryService(deliveryEnum.name())
                            .setPrice(deliveryEnum.getPrice());
                  delivery= this.onCreate(delivery);
//                            .setActive(true)
//                            .setCreateFrom("system")
//                            .setCreateOn(LocalDateTime.now())
//                                    .setModifiedOn(LocalDateTime.now())
//                                    .setModifiedFrom("system");
                    return delivery;
                })
                .collect(Collectors.toList());
        deliveryRepository.saveAllAndFlush(deliveryOptions);
    }
}
