package com.project.shop.service.impl;

import com.project.shop.model.entity.Account;
import com.project.shop.model.entity.Listing;
import com.project.shop.model.service.ListingServiceModel;
import com.project.shop.model.view.ListingInListViewModel;
import com.project.shop.repository.ListingRepository;
import com.project.shop.service.*;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
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
    private final AccountService accountService;

    public ListingServiceImpl(ListingRepository listingRepository,
                              ModelMapper modelMapper, CategoryService categoryService,
                              ConditionService conditionService, SellingFormatService sellingFormatService,
                              DeliveryService deliveryService, AccountService accountService) {
        this.listingRepository = listingRepository;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
        this.conditionService = conditionService;
        this.sellingFormatService = sellingFormatService;
        this.deliveryService = deliveryService;
        this.accountService = accountService;
    }


    @Override
    public Collection<ListingInListViewModel> getAllListings(Authentication authentication, String query, int page, int limit) {
        log.info("Fetch Listings from page " + page + " with " + limit + "/page");
        Stream<Listing> listingStream = listingRepository.findAll(PageRequest.of(page, limit))
                .stream()
                //   .filter(BaseEntity::isActive)
                ;
        Stream<ListingInListViewModel> collect = listingStream
                .map(l -> {
                    ListingInListViewModel model = modelMapper.map(l, ListingInListViewModel.class);
                    System.out.println();
                    return model;
                });

        return collect.collect(Collectors.toList());
    }

    @Override
    public Optional<Listing> getListingById(UUID id) {
        log.info("Details for listing with id: " + id);
        return listingRepository.findById(id);
    }

    @Override
    public boolean deleteListing(UUID id, String username) throws IllegalAccessException {
        Optional<Listing> listing = listingRepository
                .findById(id);
        if (listing.isEmpty()) {
            return false;
        }
        if (!listing.get().getSeller().getUsername().equals(username)) {
            throw new IllegalAccessException("You are not authorise to delete this item");
        }
        log.info("Deleted listing id: " + id);
        listing.get().setActive(false);
        Listing listing1 = this.onModify(listing.get(), username);
        listingRepository.saveAndFlush(listing1);
        return true;
    }

    @Override
    public UUID createListing(ListingServiceModel listingServiceModel) {
        Listing listing = modelMapper.map(listingServiceModel, Listing.class);
        Account account = this.accountService.findByUsername(listingServiceModel.getUsernameCreator()).orElseThrow(() ->
                new NullPointerException("You are not make registration yet"));
        listing.setSeller(account);
        setNestedEntities(listing, listingServiceModel);
        listing = this.onCreate(listing, account.getUsername());

        Listing listing1 = listingRepository.saveAndFlush(listing);
        log.info("Create listing id: " + listing.getId().toString());
        return listing1.getId();
    }

    @Override

    public UUID updateListing(ListingServiceModel listingServiceModel) {
        Listing listing = listingRepository.findById(listingServiceModel.getId())
                .orElseThrow(() -> new NullPointerException("Listing with this "
                        + listingServiceModel.getId().toString() + " does not exist"));
        Account account = this.accountService.findByUsername(listingServiceModel.getUsernameCreator()).orElseThrow(() ->
                new NullPointerException("You are not make registration yet"));

        Listing listingMapped = modelMapper.map(listingServiceModel, Listing.class);
        listingMapped.setId(listing.getId());
        listingMapped.setSeller(account);
        setNestedEntities(listingMapped, listingServiceModel);
        listingMapped.setCreateOn(listing.getCreateOn())
                .setCreateFrom(listing.getCreateFrom())
                .setActive(true);
        listingMapped = this.onModify(listingMapped, account.getUsername());
        Listing listing1 = listingRepository.saveAndFlush((listingMapped));
        log.info("Updated listing id: " + listing1.getId().toString());
        return listing1.getId();
    }

    @Override
    public void updateListing(Listing listing) {
        listing = this.onModify(listing, "system-order");
        listingRepository.saveAndFlush((listing));
        log.info("Decrease listing quantity");

    }

    @Override
    public Collection<ListingInListViewModel> getWatchListings(String username, int page, int limit) {
        log.info("Fetch Listings from page " + page + " with " + limit + "/page");
        Stream<Listing> listingStream = listingRepository.findAll(PageRequest.of(page, limit))
                .stream()
//                   .filter(BaseEntity::isActive)
                //todo replace from my to watch
                .filter(e -> e.getSeller().getUsername().equals(username));
        Stream<ListingInListViewModel> collect = listingStream
                .map(l -> {
                    ListingInListViewModel model = modelMapper.map(l, ListingInListViewModel.class);
                    System.out.println();
                    return model;
                });

        return collect.collect(Collectors.toList());
    }
    @Override
    public List<Listing> getAllById(List<UUID> ids){
        return listingRepository.findAllById(ids);
    }



    private Listing setNestedEntities(Listing listingMapped, ListingServiceModel listingServiceModel) {
        listingMapped.setCategory(categoryService.find(listingServiceModel.getCategory()));
        listingMapped.setCondition(conditionService.find(listingServiceModel.getCondition()));
        listingMapped.setSellingFormat(sellingFormatService.create(listingServiceModel.getSellingFormat()));
        listingMapped.setDeliveryDomestic(deliveryService.create(listingServiceModel.getDeliveryDomestic()));
        listingMapped.setDeliveryInternational(deliveryService.create(listingServiceModel.getDeliveryInternational()));
        return listingMapped;
    }

}
