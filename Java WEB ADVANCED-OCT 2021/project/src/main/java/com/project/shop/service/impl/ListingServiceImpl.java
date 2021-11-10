package com.project.shop.service.impl;

import com.project.shop.model.entity.BaseEntity;
import com.project.shop.model.entity.Listing;
import com.project.shop.model.service.ListingServiceModel;
import com.project.shop.model.view.ListingViewModel;
import com.project.shop.repository.ListingRepository;
import com.project.shop.service.ListingService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ListingServiceImpl implements ListingService {

    private final ListingRepository listingRepository;
    private final ModelMapper modelMapper;

    public ListingServiceImpl(ListingRepository listingRepository,
                              ModelMapper modelMapper) {
        this.listingRepository = listingRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public Collection<ListingViewModel> getAllListings() {
        return listingRepository.findAll()
                .stream()
                .filter(BaseEntity::isActive)
                .map(l->modelMapper.map(l,ListingViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public ListingViewModel getListingById(UUID id) {
        Listing listing = listingRepository.findById(id).filter(BaseEntity::isActive).orElseThrow(() -> new NullPointerException("Listing with this " + id.toString() + " does not exist"));
        return modelMapper.map(listing,ListingViewModel.class);
    }

    @Override
    public void deleteListing(UUID id) {
        Listing listing = listingRepository.findById(id).orElseThrow(() -> new NullPointerException("Listing with this " + id.toString() + " does not exist"));
        listing.setActive(false);
       listingRepository.saveAndFlush(listing);
    }

    @Override
    public ListingViewModel createListing(ListingServiceModel listingServiceModel) {

        Listing listing = modelMapper.map(listingServiceModel, Listing.class);
            listing.setActive(true);
        listingRepository.saveAndFlush(listing);
        return modelMapper.map(listing,ListingViewModel.class);
    }

    @Override
    @Transactional
    public ListingViewModel updateListing(ListingServiceModel listingServiceModel) {
        Listing listing = listingRepository.findById(listingServiceModel.getId())
                .orElseThrow(() -> new NullPointerException("Listing with this "
                        + listingServiceModel.getId().toString() + " does not exist"));

        Listing  listingMapped=modelMapper.map(listingServiceModel,Listing.class);

        Listing listing1 = listingRepository.saveAndFlush(listingMapped);
        return modelMapper.map(listing1,ListingViewModel.class);
    }
}
