package com.project.shop.service;

import com.project.shop.model.entity.Listing;
import com.project.shop.model.service.ListingServiceModel;
import com.project.shop.model.view.ListingInListViewModel;
import org.springframework.security.core.Authentication;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ListingService {


    Collection<ListingInListViewModel> getAllListings(Authentication authentication, String query, int page, int limit);

    Optional<Listing> getListingById(UUID id);

    boolean deleteListing(UUID id, String username) throws IllegalAccessException;

    UUID createListing(ListingServiceModel listingServiceModel);

    UUID updateListing(ListingServiceModel listingServiceModel);


    Collection<ListingInListViewModel> getWatchListings(String username, int page, int limit);
    List<Listing> getAllById(List<UUID> ids);

    void updateListing(Listing listing);

    boolean watchListing(UUID id, String username);
}
