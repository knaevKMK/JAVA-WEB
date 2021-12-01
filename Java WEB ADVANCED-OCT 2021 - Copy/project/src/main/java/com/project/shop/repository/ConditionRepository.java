package com.project.shop.repository;

import com.project.shop.model.entity.ConditionItem;
import com.project.shop.model.enums.ConditionEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ConditionRepository extends JpaRepository<ConditionItem, UUID> {
    Optional<ConditionItem> findByTitle(String title);
}
