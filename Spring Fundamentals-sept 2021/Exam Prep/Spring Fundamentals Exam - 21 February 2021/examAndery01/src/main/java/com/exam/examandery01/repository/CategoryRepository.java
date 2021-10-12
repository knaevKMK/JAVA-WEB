package com.exam.examandery01.repository;

import com.exam.examandery01.model.entity.Category;
import com.exam.examandery01.model.entity.CategoryName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,String> {
    Category findByCategoryName(CategoryName categoryName);
}
