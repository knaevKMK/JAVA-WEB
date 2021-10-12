package com.exam.examandery01.service.impl;

import com.exam.examandery01.model.entity.Category;
import com.exam.examandery01.model.entity.CategoryName;
import com.exam.examandery01.model.services.CategoryServiceModel;
import com.exam.examandery01.repository.CategoryRepository;
import com.exam.examandery01.service.CategoryService;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMap;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMap) {
        this.categoryRepository = categoryRepository;
        this.modelMap = modelMap;
    }

    @Override
    public void SeedData() {
        if (this.categoryRepository.count() == 0) {
            Arrays.stream(CategoryName.values())
                    .forEach(categoryName -> {
                        Category category = new Category();
                        category.setCategoryName(categoryName)
                                .setDescription(String.format("Descripton for %s", categoryName));
                        this.categoryRepository.save(category);
                    });
        }
    }

    @Override
    public Category findByCategoryName(CategoryServiceModel category) {
        return this.categoryRepository.findByCategoryName(category.getCategory());
    }
}
