package com.project.shop.service.impl;

import com.project.shop.model.view.CategoryViewModel;

import com.project.shop.service.CategoryService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
@Service
public class CategoryServiceImpl implements CategoryService {


    @Override
    public void create(String name) {

    }

    @Override
    public List<CategoryViewModel> getAll() {
        return null;
    }
}
