package com.project.shop.repository;

import com.project.shop.model.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface FeedBackRepository extends JpaRepository<Feedback, UUID> {
    List<Feedback> findAllByOrder_Id(UUID orderId);

    @Query(value = "select f FROM Feedback f where f.order.buyer.username = ?1")
    List<Feedback> findAllByOrder_Buyer_Username(String username);


    @Query(value = "select f FROM Feedback f where f.order.listing.createFrom = ?1")
    List<Feedback> findAllByOrder_Listing_CreatFrom(String username);


    @Query(value = "select f from Feedback f where f.positive=?1 and (f.createFrom=?2 Or f.order.listing.createFrom=?3)")
    List<Feedback> findAllByPositiveAndOrder_Listing_CreateFromOrOrder_Buyer_Username(boolean b, String username, String buyerUsername);
}
