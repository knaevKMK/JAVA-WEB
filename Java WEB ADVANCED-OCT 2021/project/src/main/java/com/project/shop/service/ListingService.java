package com.project.shop.service;

import com.project.shop.model.service.ListingServiceModel;
import com.project.shop.model.view.ListingViewModel;

import java.util.Collection;
import java.util.UUID;

public interface ListingService {


    Collection<ListingViewModel> getAllListings();

    ListingViewModel getListingById(UUID id);

    void deleteListing(UUID id);

    ListingViewModel createListing(ListingServiceModel listingServiceModel);

    ListingViewModel updateListing(ListingServiceModel listingServiceModel);
}
