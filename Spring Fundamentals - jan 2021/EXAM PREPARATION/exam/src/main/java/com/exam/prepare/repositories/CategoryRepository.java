package com.exam.prepare.repositories;

import com.exam.prepare.model.entities.CategoryEntity;
import com.exam.prepare.model.entities.enums.CategoryNameEnum;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, String> {
    Optional<CategoryEntity> findByName(CategoryNameEnum name);
}
