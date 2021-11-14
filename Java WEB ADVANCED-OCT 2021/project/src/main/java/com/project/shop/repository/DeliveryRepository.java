package com.project.shop.repository;

import com.project.shop.model.entity.DeliveryOptions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface DeliveryRepository extends JpaRepository<DeliveryOptions, UUID> {
}
