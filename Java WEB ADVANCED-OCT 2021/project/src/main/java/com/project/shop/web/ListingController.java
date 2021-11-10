package com.project.shop.web;

import com.project.shop.model.binding.ListingCreateModel;
import com.project.shop.model.service.ListingServiceModel;
import com.project.shop.model.view.ListingViewModel;
import com.project.shop.service.ListingService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

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
    public ResponseEntity<Collection<ListingViewModel>> getAllListings() {
        return ResponseEntity.ok(listingService.getAllListings());
    }

    @GetMapping("listing/{id}")
    public ResponseEntity<ListingViewModel> getListingById(@PathVariable UUID id) {
        try{
        return ResponseEntity.ok(listingService.getListingById(id));
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Boolean> deleteListingById(@PathVariable UUID id) {
        try{
            listingService.deleteListing(id);
        return ResponseEntity.ok(true);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("add")
    public ResponseEntity<ListingViewModel> createListing(@RequestBody ListingCreateModel listingCreateModel
                                                     //   , Authentication authentication
      , UriComponentsBuilder builder) {
        String listingId = listingService.createListing(modelMapper.map(listingCreateModel,ListingServiceModel.class));

        URI location = builder.path("/api/listing/{id}").
                buildAndExpand(listingId).toUri();

        return ResponseEntity.
                created(location).
                build();
        }

    @PutMapping("update/{id}")
    public ResponseEntity<ListingViewModel> updateListing(@PathVariable("id") UUID id,
                                                          @RequestBody ListingCreateModel listingCreateModel,UriComponentsBuilder builder) {
        if(listingCreateModel.getId() != id){
            return ResponseEntity.notFound().build();
        }

        try{
            String listingId = listingService.updateListing(modelMapper.map(listingCreateModel,ListingServiceModel.class));
            //   log.info("Offer updated: {}", updated);

                URI location = builder.path("/api/listing/{id}").
                        buildAndExpand(listingId).toUri();
            return     ResponseEntity.
                        created(location).
                        build();

        }catch (Exception e){

            return  ResponseEntity.badRequest().build();
        }
    }
}
