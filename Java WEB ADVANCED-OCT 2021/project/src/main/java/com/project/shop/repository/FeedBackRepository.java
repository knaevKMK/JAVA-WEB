package com.project.shop.repository;

import com.project.shop.model.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.UUID;
@Repository
public interface FeedBackRepository extends JpaRepository<Feedback, UUID> {
    List<Feedback> findAllByOrder_Id(UUID orderId);

    @Query(value = "select f FROM Feedback f where f.order.buyer.username = ?1")
    List<Feedback> findAllByOrder_Buyer_Username(String username);


    @Query(value = "select f FROM Feedback f where f.order.listing.createFrom = ?1")
    List<Feedback> findAllByOrder_Listing_CreatFrom(String username);

    List<Feedback> findAllByPositiveIsTrueAndOrder_Listing_CreateFrom(String username);

    List<Feedback> findAllByPositiveIsFalseAndOrder_Listing_CreateFrom(String username);
}
