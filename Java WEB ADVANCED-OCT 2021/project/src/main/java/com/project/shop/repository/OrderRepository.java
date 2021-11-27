package com.project.shop.repository;

import com.project.shop.model.entity.Order;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.UUID;
@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {
    @Modifying
    @Query(value = "alter table ORDER add column quantity int(5) not null default 1", nativeQuery = true)
    void addQuantityColumn();

    @Modifying
    @Query(value = "alter table ORDER add column price decimal not null ", nativeQuery = true)
    void addPriceColumn();

    Collection<Order> findAllByActiveIsTrueAndBuyer_Username(String username );
    Collection<Order> findAllByActiveIsTrueAndListing_CreateFrom(String username);
}
