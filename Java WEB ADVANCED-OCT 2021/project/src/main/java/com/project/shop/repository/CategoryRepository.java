package com.project.shop.repository;

import com.project.shop.model.entity.CategoryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryItem, UUID> {
    Optional<CategoryItem> findByTitleAndParentCategoryTitle(String title, String parentCategory );
    CategoryItem findCategoryItemByTitle(String title);
}
