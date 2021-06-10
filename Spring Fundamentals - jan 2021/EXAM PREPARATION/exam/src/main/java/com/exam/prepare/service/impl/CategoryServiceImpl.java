package com.exam.prepare.service.impl;

import com.exam.prepare.model.entities.CategoryEntity;
import com.exam.prepare.model.entities.ProductEntity;
import com.exam.prepare.model.entities.enums.CategoryNameEnum;
import com.exam.prepare.model.service.ProductServiceModel;
import com.exam.prepare.repositories.CategoryRepository;
import com.exam.prepare.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;


    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryService categoryService, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
    }



    @Override
    public void initCategories() {
        if (this.categoryRepository.count() == 0) {
            Arrays.stream(CategoryNameEnum.values())
                    .forEach(categoryName -> {
                        CategoryEntity categoryEntity =
                                new CategoryEntity( categoryName,
                                        "Description for " + categoryName.name());

                        this.categoryRepository.save(categoryEntity);
                    });
        }
    }

    @Override
    public CategoryEntity findCategoryByName(CategoryNameEnum name) {
      return  this.categoryRepository.findByName(name).orElse(null);
    }

}
