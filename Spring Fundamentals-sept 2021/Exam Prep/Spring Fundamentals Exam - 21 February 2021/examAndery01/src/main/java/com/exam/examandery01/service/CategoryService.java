package com.exam.examandery01.service;

import com.exam.examandery01.model.entity.Category;
import com.exam.examandery01.model.services.CategoryServiceModel;
import org.springframework.stereotype.Service;

@Service
public interface CategoryService {

    void SeedData();

    Category findByCategoryName(CategoryServiceModel category);
}
