package com.exam.prepare.service.impl;

import com.exam.prepare.model.entities.ProductEntity;
import com.exam.prepare.model.service.ProductServiceModel;
import com.exam.prepare.repositories.ProductRepository;
import com.exam.prepare.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;

        this.modelMapper = modelMapper;
    }

    @Override
    public void addProduct(ProductServiceModel productServiceModel) {
        ProductEntity productEntity = modelMapper.map(productServiceModel, ProductEntity.class);
        this.productRepository.save(productEntity);
    }
}
