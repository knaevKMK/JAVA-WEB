package com.exam.prepare.service;

import com.exam.prepare.model.entities.CategoryEntity;
import com.exam.prepare.model.entities.enums.CategoryNameEnum;
import com.exam.prepare.model.service.ProductServiceModel;

public interface CategoryService {
    void initCategories();

    CategoryEntity findCategoryByName(CategoryNameEnum name);
}
