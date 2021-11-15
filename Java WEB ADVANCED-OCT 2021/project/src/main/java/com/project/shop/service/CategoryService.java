package com.project.shop.service;

import com.project.shop.model.binding.CategoryBindingModel;
import com.project.shop.model.entity.CategoryItem;
import com.project.shop.model.view.CategoryViewModel;

import java.util.List;

public interface CategoryService {
    void seedData();
    List<CategoryViewModel> getAll();

    CategoryItem find(CategoryBindingModel itemCategoryItem);
}
