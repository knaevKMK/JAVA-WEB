package com.project.shop.repository;

import com.project.shop.model.entity.Listing;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.UUID;

@Repository
public interface ListingRepository extends JpaRepository<Listing, UUID> {
    Slice<Listing> findAllByCreateFrom(String createFrom, Pageable listingPage);

    @Query(value = "SELECT l.watchList FROM Account l where l.username= :watcherName" )
    Slice<Listing> findAllWatched(String watcherName, Pageable listingPage);

    Slice<Listing> findAllByCreateOnAfter(LocalDateTime after, Pageable listingPage);

    Slice<Listing> findAllByCreateOnBefore(LocalDateTime before, Pageable listingPage);

    Slice<Listing> findAllByTitleContainingOrDescriptionContaining(String search, String search2, Pageable listingPage);
}
