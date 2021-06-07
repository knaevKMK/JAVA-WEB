package com.exam.prepare.repositories;

import com.exam.prepare.model.entities.CategoryEntity;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, String> {
}
