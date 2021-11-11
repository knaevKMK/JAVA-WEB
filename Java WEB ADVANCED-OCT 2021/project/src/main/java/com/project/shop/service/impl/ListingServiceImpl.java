package com.project.shop.service.impl;

import com.project.shop.model.entity.BaseEntity;
import com.project.shop.model.entity.Listing;
import com.project.shop.model.service.ListingServiceModel;
import com.project.shop.model.view.ListingViewModel;
import com.project.shop.repository.ListingRepository;
import com.project.shop.service.ListingService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@Transactional
@Slf4j
public class ListingServiceImpl implements ListingService {

    private final ListingRepository listingRepository;
    private final ModelMapper modelMapper;

    public ListingServiceImpl(ListingRepository listingRepository,
                              ModelMapper modelMapper) {
        this.listingRepository = listingRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public Collection<ListingViewModel> getAllListings(int page, int limit) {
        log.info("Fetch Listings from page " + page + " with " + limit + "/page");
        return listingRepository.findAll(PageRequest.of(page, limit))
                .stream()
                .filter(BaseEntity::isActive)
                .map(l -> modelMapper.map(l, ListingViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public ListingViewModel getListingById(UUID id) {
        log.info("Details for listing with id: " + id);
        Optional<Listing> listing = listingRepository
                .findById(id)
                .filter(BaseEntity::isActive);
        //  .orElseThrow(() -> new NullPointerException("Listing with this " + id.toString() + " does not exist"));

        return modelMapper.map(listing, ListingViewModel.class);
    }

    @Override
    public boolean deleteListing(UUID id) {
        Optional<Listing> listing = listingRepository
                .findById(id);
        if (listing.isEmpty()) {
            return false;
        }
        log.info("Deleted listing id: " + id);
        listing.get().setActive(false);
        listingRepository.saveAndFlush(listing.get());
        return true;
    }

    @Override
    public ListingViewModel createListing(ListingServiceModel listingServiceModel) {
        Listing listing = modelMapper.map(listingServiceModel, Listing.class);
      listing=seedCreateLog(listing);
        Listing listing1 = listingRepository.saveAndFlush(listing);
        log.info("Create listing id: " + listing.getId().toString());
        return modelMapper.map(listing1,ListingViewModel.class);
    }

    @Override

    public ListingViewModel updateListing(ListingServiceModel listingServiceModel) {
        Listing listing = listingRepository.findById(listingServiceModel.getId())
                .orElseThrow(() -> new NullPointerException("Listing with this "
                        + listingServiceModel.getId().toString() + " does not exist"));

        Listing listingMapped = modelMapper.map(listingServiceModel, Listing.class);

        Listing listing1 = listingRepository.saveAndFlush((listingMapped));
        log.info("Updated listing id: " + listing1.getId().toString());
        return modelMapper.map(listing1,ListingViewModel.class);
    }
    private Listing seedModifyLog(Listing listing){

              listing.setModifiedOn(LocalDateTime.now());
      //todo set
      listing.setModifiedFrom("system");
        return listing;
    }
    private Listing seedCreateLog(Listing listing){
        //todo set
      listing.setCreateFrom("system");
        listing.setCreateOn(LocalDateTime.now());
        return seedModifyLog(listing);
    }
}
