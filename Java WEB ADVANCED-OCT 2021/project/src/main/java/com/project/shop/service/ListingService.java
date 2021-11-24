package com.project.shop.service;

import com.project.shop.model.binding.BuyBindingModel;
import com.project.shop.model.service.ListingServiceModel;
import com.project.shop.model.view.ListingInListViewModel;
import com.project.shop.model.view.ListingViewModel;

import java.util.Collection;
import java.util.UUID;

public interface ListingService {


    Collection<ListingInListViewModel> getAllListings(int page, int limit);

    ListingViewModel getListingById(UUID id);

    boolean deleteListing(UUID id, String username) throws IllegalAccessException;

    UUID createListing(ListingServiceModel listingServiceModel);

    UUID updateListing(ListingServiceModel listingServiceModel);

    UUID buy(BuyBindingModel buyBindingModel, String username);
}
