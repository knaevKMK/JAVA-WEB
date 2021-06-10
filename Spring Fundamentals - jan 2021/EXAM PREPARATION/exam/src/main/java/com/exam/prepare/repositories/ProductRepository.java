package com.exam.prepare.repositories;

import com.exam.prepare.model.entities.ProductEntity;
import com.exam.prepare.model.service.ProductServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, String> {

    @Query("SELECT SUM(p.price) FROM ProductEntity p")
    BigDecimal findTotalProductPrice();
}
