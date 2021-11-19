package com.project.shop.service.impl;

import com.project.shop.model.entity.BaseEntity;
import com.project.shop.model.entity.Listing;
import com.project.shop.model.service.ListingServiceModel;
import com.project.shop.model.view.ListingInListViewModel;
import com.project.shop.model.view.ListingViewModel;
import com.project.shop.repository.ListingRepository;
import com.project.shop.service.*;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
@Transactional
@Slf4j
public class ListingServiceImpl extends BaseServiceImpl<Listing> implements ListingService {

    private final ListingRepository listingRepository;
    private final ModelMapper modelMapper;
    private final CategoryService categoryService;
    private final ConditionService conditionService;
    private final SellingFormatService sellingFormatService;
    private final DeliveryService deliveryService;

    public ListingServiceImpl(ListingRepository listingRepository,
                              ModelMapper modelMapper, CategoryService categoryService, ConditionService conditionService, SellingFormatService sellingFormatService, DeliveryService deliveryService) {
        this.listingRepository = listingRepository;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
        this.conditionService = conditionService;
        this.sellingFormatService = sellingFormatService;
        this.deliveryService = deliveryService;
    }


    @Override
    public Collection<ListingInListViewModel> getAllListings(int page, int limit) {
        log.info("Fetch Listings from page " + page + " with " + limit + "/page");
        Stream<Listing> listingStream = listingRepository.findAll(PageRequest.of(page, limit))
                .stream()
                .filter(BaseEntity::isActive);
        Stream<ListingInListViewModel> collect = listingStream
                .map(l -> {
                    ListingInListViewModel model = modelMapper.map(l, ListingInListViewModel.class);
                    System.out.println();
                    return  model;
                });

        return collect.collect(Collectors.toList());
    }

    @Override
    public ListingViewModel getListingById(UUID id) {
        log.info("Details for listing with id: " + id);
        Optional<Listing> listing = listingRepository
                .findById(id)
                //.filter(BaseEntity::isActive)
                ;
        //  .orElseThrow(() -> new NullPointerException("Listing with this " + id.toString() + " does not exist"));

        return modelMapper.map(listing.get(), ListingViewModel.class);
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
        Listing listing1 = this.onModify(listing.get());
        listingRepository.saveAndFlush(listing1);
        return true;
    }

    @Override
    public UUID createListing(ListingServiceModel listingServiceModel) {
        Listing listing = modelMapper.map(listingServiceModel, Listing.class);

        listing.setCategory(categoryService.find(listingServiceModel.getCategory()));
        listing.setCondition(conditionService.find(listingServiceModel.getCondition()));
        listing.setSellingFormat(sellingFormatService.create(listingServiceModel.getSellingFormat()));
        listing.setDeliveryDomestic(deliveryService.create(listingServiceModel.getDeliveryDomestic()));
        listing.setDeliveryInternational(deliveryService.create(listingServiceModel.getDeliveryInternational()));
        listing = this.onCreate(listing);

           Listing listing1 = listingRepository.saveAndFlush(listing);
        log.info("Create listing id: " + listing.getId().toString());
        return listing1.getId();
    }

    @Override

    public UUID updateListing(ListingServiceModel listingServiceModel) {
        Listing listing = listingRepository.findById(listingServiceModel.getId())
                .orElseThrow(() -> new NullPointerException("Listing with this "
                        + listingServiceModel.getId().toString() + " does not exist"));

        Listing listingMapped = modelMapper.map(listingServiceModel, Listing.class);
      listingMapped.setId(listing.getId());
        listingMapped.setCategory(categoryService.find(listingServiceModel.getCategory()));
        listingMapped.setCondition(conditionService.find(listingServiceModel.getCondition()));
        listingMapped.setSellingFormat(sellingFormatService.create(listingServiceModel.getSellingFormat()));
        listingMapped.setDeliveryDomestic(deliveryService.create(listingServiceModel.getDeliveryDomestic()));
        listingMapped.setDeliveryInternational(deliveryService.create(listingServiceModel.getDeliveryInternational()));
        listingMapped.setCreateOn(listing.getCreateOn());
        listingMapped.setCreateFrom(listing.getCreateFrom());
        listingMapped.setActive(true);
        listingMapped = this.onModify(listingMapped);
        Listing listing1 = listingRepository.saveAndFlush((listingMapped));
        log.info("Updated listing id: " + listing1.getId().toString());
        return listing1.getId();
    }

}
