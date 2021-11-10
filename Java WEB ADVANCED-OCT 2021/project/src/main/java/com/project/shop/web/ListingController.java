package com.project.shop.web;


import com.fasterxml.jackson.annotation.JsonView;
import com.project.shop.model.binding.ListingCreateModel;
import com.project.shop.model.service.ListingServiceModel;
import com.project.shop.model.view.ListingViewModel;
import com.project.shop.service.ListingService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping("/api/listings")
public class ListingController {


    private final ListingService listingService;
    private final ModelMapper modelMapper;

    public ListingController(ListingService listingService, ModelMapper modelMapper) {
        this.listingService = listingService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("all")
    @JsonView(ListingViewModel.class)
    public Collection<ListingViewModel> all() {
        return listingService.getAllListings();
    }

    @GetMapping("listing/{id}")
    @JsonView(ListingViewModel.class)
    public ListingViewModel listingById(@PathVariable UUID id) {
        return listingService.getListingById(id);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable UUID id) {
             //   listingService.deleteListing(id);
        return ResponseEntity.ok(true);
    }

    @PostMapping("add")
    @JsonView(ListingViewModel.class)
    public ResponseEntity<ListingViewModel> add(@RequestBody ListingCreateModel listingCreateModel
                                                     //   , Authentication authentication
    ) {
//        User author = userService.getUserByUsername(authentication.getName());
//        offer.setAuthor(author);
        ListingViewModel created = listingService.createListing(modelMapper.map(listingCreateModel, ListingServiceModel.class));
        URI location = MvcUriComponentsBuilder.fromMethodName(ListingController.class, "addListing", listingCreateModel
        //        , authentication
        )
                .pathSegment("{id}").buildAndExpand(created.getId()).toUri() ;
        return ResponseEntity.created(location).body(created);
//        return ResponseEntity.status(303).location(location).body(created);
    }

    @PutMapping("update/{id}")
    @JsonView(ListingViewModel.class)
    public ResponseEntity<ListingViewModel> update(@PathVariable UUID id, @RequestBody ListingCreateModel listingCreateModel) {
        if(listingCreateModel.getId() != id) throw new NullPointerException(
                String.format("Listing ID=%s from path is different from Entity ID=%s", id, listingCreateModel.getId()));
        ListingViewModel updated = listingService.updateListing(modelMapper.map(listingCreateModel,ListingServiceModel.class));
     //   log.info("Offer updated: {}", updated);
        return ResponseEntity.ok(updated);
    }

}
