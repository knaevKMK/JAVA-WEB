package com.project.shop.web;

import com.project.shop.infrastructure.identity.models.entity.UserEntity;
import com.project.shop.model.Response;
import com.project.shop.model.binding.ListingCreateModel;
import com.project.shop.model.entity.Listing;
import com.project.shop.model.service.ListingServiceModel;
import com.project.shop.model.view.ListingInListViewModel;
import com.project.shop.model.view.ListingViewModel;
import com.project.shop.service.ListingService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.UUID;


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


    @GetMapping("/all")
    public ResponseEntity<Response> getAllListings( @RequestParam(required = false) String sortBy,
                                                    @RequestParam (required = false)String sort,
                                                    @RequestParam(required = false) String filter,
                                                    @RequestParam (required = false)String search,
                                                    @RequestParam(required = false, defaultValue = "0") int page,
                                                    @RequestParam(required = false, defaultValue = "30") int limit,
                                                   Authentication authentication) {

        List<ListingInListViewModel> allListings = listingService.getAllListings(authentication, page,limit,sortBy,sort,filter,search);
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
            Listing listing = listingService.getListingById(id)
                    .orElseThrow(() -> new NullPointerException("Listing does not exist"));
            ListingViewModel listingModel = modelMapper.map(listing, ListingViewModel.class);
            if (authentication != null) {
                UserEntity principal = (UserEntity) authentication.getPrincipal();
                listingModel.setOwner(listing.getCreateFrom().equals(principal.getUsername()));
                listingModel.setWatched(listing.getWatchers()
                        .stream().
                        anyMatch(l -> l.getUsername().equals(principal.getUsername())));
            }
            return ResponseEntity.ok(response
                    .setOkRequestResponse("listing", listingModel, "Listing with id: " + id.toString() + "  retrieved"));
        } catch (Exception e) {

            return ResponseEntity.ok(response
                    .setBadRequestResponse("id", id, e, e.getMessage()));
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

    @GetMapping("watch/{id}")
    public ResponseEntity<Response> watch(@PathVariable UUID id
            , Authentication authentication
    ) {
        Response response = new Response();
        try {
            if (authentication != null) {
                UserEntity principal = (UserEntity) authentication.getPrincipal();
                boolean watch = listingService.watchListing(id, principal.getUsername());

                return ResponseEntity.ok(response
                        .setOkRequestResponse("watch", watch, "Listing with id: " + id.toString() + "  watched"));
            }
            throw new NullPointerException("Please Sign - in first");
        } catch (Exception e) {

            return ResponseEntity.ok(response
                    .setBadRequestResponse("watch", id, e, e.getMessage()));
        }
    }

}
