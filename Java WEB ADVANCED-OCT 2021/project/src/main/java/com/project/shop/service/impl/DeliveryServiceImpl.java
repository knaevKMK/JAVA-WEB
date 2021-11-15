package com.project.shop.service.impl;

import com.project.shop.model.binding.DeliveryBindingModel;
import com.project.shop.model.entity.DeliveryOptions;
import com.project.shop.repository.DeliveryRepository;
import com.project.shop.service.DeliveryService;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class DeliveryServiceImpl extends BaseServiceImpl<DeliveryOptions> implements DeliveryService {
    private final DeliveryRepository deliveryRepository;
    private final ModelMapper modelMapper;

    public DeliveryServiceImpl(DeliveryRepository deliveryRepository, ModelMapper modelMapper) {
        this.deliveryRepository = deliveryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedData() {

    }

    @Override
    public DeliveryOptions create(DeliveryBindingModel deliveryOptionsModel) {
        DeliveryOptions deliveryOptions = modelMapper.map(deliveryOptionsModel, DeliveryOptions.class);
        return deliveryRepository.saveAndFlush(deliveryOptions);
    }
}
