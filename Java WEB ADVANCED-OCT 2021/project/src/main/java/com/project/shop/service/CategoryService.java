package com.project.shop.service;

import com.project.shop.model.view.CategoryViewModel;

import java.util.List;

public interface CategoryService {
    void create(String name);
    List<CategoryViewModel> getAll();
}
