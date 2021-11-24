package com.project.shop.web;

import com.project.shop.infrastructure.identity.models.entity.UserEntity;
import com.project.shop.model.Response;
import com.project.shop.model.binding.BuyBindingModel;
import com.project.shop.model.binding.ListingCreateModel;
import com.project.shop.model.service.ListingServiceModel;
import com.project.shop.model.view.ListingInListViewModel;
import com.project.shop.model.view.ListingViewModel;
import com.project.shop.service.ListingService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.UUID;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@CrossOrigin
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
        Collection<ListingInListViewModel> allListings = listingService.getAllListings(0, 30);
        Response response = new Response();
        return ResponseEntity.ok(response
                .setOkRequestResponse("listings", allListings, "Listings retrieved"));
    }

    @GetMapping("listing/{id}")
    public ResponseEntity<Response> getListingById(@PathVariable UUID id
            , Authentication authentication
    ) {
        Response response = new Response();
        try {
            ListingViewModel listing  = listingService.getListingById(id);
            if (authentication != null) {
                UserEntity principal = (UserEntity) authentication.getPrincipal();
                listing.setOwner(listing.getCreateFrom().equals(principal.getUsername()));
            }
            return ResponseEntity.ok(response
                    .setOkRequestResponse("listing", listing, "Listing with id: " + id.toString() + "  retrieved"));
        } catch (Exception e) {

            return ResponseEntity.ok(response
                    .setBadRequestResponse("id", id, e, "Listing with id:" + id.toString() + "does not exist"));
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Response> deleteListingById(@PathVariable UUID id
            , Authentication authentication
    ) {
        Response response = new Response();
        try {
            if (authentication == null) {
                throw new IllegalStateException("You are not authorize to delete this item");
            }
            UserEntity principal = (UserEntity) authentication.getPrincipal();
            boolean isDeleted = listingService.deleteListing(id, principal.getUsername());
            return ResponseEntity.ok(response
                    .setOkRequestResponse("deleted", isDeleted, "Listing with id: " + id.toString() + "  deleted"));
        } catch (Exception e) {

            return ResponseEntity.ok(response
                    .setBadRequestResponse("deleted", false, e, "Listing with id:" + id.toString() + "does not exist"));
        }
    }

    @PostMapping("add")
    public ResponseEntity<Response> createListing(@Valid @RequestBody ListingCreateModel listingCreateModel
            , Authentication authentication
    ) {
        Response response = new Response();
        try {
            if (authentication == null) {
                throw new UnsupportedOperationException("Login before create new listing");
            }
            UserEntity principal = (UserEntity) authentication.getPrincipal();
            ListingServiceModel listingServiceModel = modelMapper.map(listingCreateModel, ListingServiceModel.class);
            listingServiceModel.setUsernameCreator(principal.getUsername());
            var result = listingService.createListing(listingServiceModel);
            return ResponseEntity.ok(response
                    .setOkRequestResponse("id", result, "Listing created"));
        } catch (Exception e) {

            return ResponseEntity.ok(response
                    .setBadRequestResponse("listing", listingCreateModel, e, "Listing has errors"));
        }
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Response> updateListing(@PathVariable("id") UUID id,
                                                  @Valid @RequestBody ListingCreateModel listingCreateModel
            , Authentication authentication
    ) {
        Response response = new Response();
        try {
            if (authentication == null) {
                throw new IllegalStateException("You are not authorize to edit this item");
            }
            if (id == null || !listingCreateModel.getId().toString().equals(id.toString())) {
                return ResponseEntity.notFound().build();
            }

            UserEntity principal = (UserEntity) authentication.getPrincipal();
            ListingServiceModel map = modelMapper.map(listingCreateModel, ListingServiceModel.class);
            map.setUsernameCreator(principal.getUsername());
            UUID result = listingService.updateListing(map);
            return ResponseEntity.ok(response
                    .setOkRequestResponse("id", result, "Listing updated"));
        } catch (Exception e) {

            return ResponseEntity.ok(response
                    .setBadRequestResponse("listing", listingCreateModel, e, "Listing has errors"));
        }
    }
    @PostMapping("buy")
    public ResponseEntity<Response> buyListing(  @RequestBody BuyBindingModel buyBindingModel
                                                     , Authentication authentication
    ) {
        Response response = new Response();
        try {
            if (authentication == null) {
                throw new IllegalStateException("Please Sign-in before continue");
            }
            if (buyBindingModel.getId() == null) {
                return ResponseEntity.notFound().build();
            }

            UserEntity principal = (UserEntity) authentication.getPrincipal();
            UUID order = listingService.buy(buyBindingModel,principal.getUsername());
            return ResponseEntity.ok(response
                    .setOkRequestResponse("order", order, "Listing buy it now"));
        } catch (Exception e) {

            return ResponseEntity.ok(response
                    .setBadRequestResponse("buy", buyBindingModel, e, "Buy it now has errors"));
        }
    }
}
