package com.project.shop.web;

import com.project.shop.model.Response;
import com.project.shop.model.binding.ListingCreateModel;
import com.project.shop.model.service.ListingServiceModel;
import com.project.shop.model.view.ListingViewModel;
import com.project.shop.service.ListingService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Map;
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
    public ResponseEntity<Response> getAllListings() {
        Collection<ListingViewModel> allListings = listingService.getAllListings(0, 30);
        return ResponseEntity.ok(Response
                    .builder()
                    .timeStamp(LocalDateTime.now())
                    .data(Map.of("listings",allListings))
                    .message("Listings retrieved")
                    .status(HttpStatus.OK)
                    .statusCode(HttpStatus.OK.value())
                    .build()
        );
    }

    @GetMapping("listing/{id}")
    public ResponseEntity<Response> getListingById(@PathVariable UUID id) {
        ListingViewModel listing = listingService.getListingById(id);
        return ResponseEntity.ok(Response
                .builder()
                .timeStamp(LocalDateTime.now())
                .data(Map.of("listing" , listing))
                .message("Listing with id: "+ id.toString()+"  retrieved")
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .build()
        );
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Response> deleteListingById(@PathVariable UUID id) {
        return ResponseEntity.ok(Response
                .builder()
                .timeStamp(LocalDateTime.now())
                .data(Map.of("deleted",listingService.deleteListing(id)))
                .message("Listing with id: "+ id.toString()+"  deleted")
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .build()
        );
    }

    @PostMapping("add")
    public ResponseEntity<Response> createListing(@RequestBody ListingCreateModel listingCreateModel
                                                     //   , Authentication authentication
      ) {
        return ResponseEntity.ok(Response
                .builder()
                .timeStamp(LocalDateTime.now())
                .data(Map.of("listing",listingService.createListing(modelMapper.map(listingCreateModel,ListingServiceModel.class))))
                .message("Listing created")
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .build()
        );
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Response> updateListing(@PathVariable("id") UUID id,
                                                          @RequestBody ListingCreateModel listingCreateModel,UriComponentsBuilder builder) {
        if(listingCreateModel.getId() != id){
            return ResponseEntity.notFound().build();
        }
        ListingViewModel listing = listingService.createListing(modelMapper.map(listingCreateModel, ListingServiceModel.class));

        return ResponseEntity.ok(Response
                .builder()
                .timeStamp(LocalDateTime.now())
                .data(Map.of("listing",listing))
                .message("Listing updated")
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .build()
        );
    }
}
