package com.shop.SuperMarket.service;

import com.shop.SuperMarket.model.entities.Category;
import com.shop.SuperMarket.model.service.CategoryServiceModel;
import com.shop.SuperMarket.repositories.CategoryRepository;
import com.shop.SuperMarket.service.interfaces.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    @Override
    public void addCategory(CategoryServiceModel categoryServiceModel) {
        Category category = modelMapper.map(categoryServiceModel, Category.class);
        System.out.println(category.toString());
        this.categoryRepository.save(category);
    }
}
