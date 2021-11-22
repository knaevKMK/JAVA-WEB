package com.project.shop.web;

import com.project.shop.model.Response;
import com.project.shop.model.binding.ListingCreateModel;
import com.project.shop.model.service.ListingServiceModel;
import com.project.shop.model.view.ListingInListViewModel;
import com.project.shop.model.view.ListingViewModel;
import com.project.shop.service.ListingService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
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

    @GetMapping("all")
    public ResponseEntity<Response> getAllListings() {
        Collection<ListingInListViewModel> allListings = listingService.getAllListings(0, 30);
        Response response=new  Response();
        return ResponseEntity.ok(response
                .setOkRequestResponse("listings",allListings,"Listings retrieved"));
    }

    @GetMapping("listing/{id}")
    public ResponseEntity<Response> getListingById(@PathVariable UUID id
                                                   //   , Authentication authentication
    ) {
        Response response=new  Response();
        try{
            ListingViewModel listing = listingService.getListingById(id);
            return ResponseEntity.ok(response
                    .setOkRequestResponse("listing",listing,"Listing with id: "+ id.toString()+"  retrieved"));
        }catch (Exception e) {

            return ResponseEntity.ok(response
                    .setBadRequestResponse("id", id, e, "Listing with id:" +id.toString()+"does not exist"));
        }
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Response> deleteListingById(@PathVariable UUID id
                                                      //   , Authentication authentication
                                                      ) {
        Response response=new  Response();
        try{
            boolean isDeleted = listingService.deleteListing(id);
            return ResponseEntity.ok(response
                    .setOkRequestResponse("deleted",isDeleted,"Listing with id: "+ id.toString()+"  deleted"));
        }catch (Exception e) {

            return ResponseEntity.ok(response
                    .setBadRequestResponse("deleted", false, e, "Listing with id:" +id.toString()+"does not exist"));
        }
    }
    @PostMapping("add")
    public ResponseEntity<Response> createListing(@Valid @RequestBody ListingCreateModel listingCreateModel
                                                     //   , Authentication authentication
      ) {
        Response response=new  Response();
        try{
            var result = listingService.createListing(modelMapper.map(listingCreateModel, ListingServiceModel.class));
            return ResponseEntity.ok(response
                    .setOkRequestResponse("id",result,"Listing created"));
        }catch (Exception e) {

            return ResponseEntity.ok(response
                    .setBadRequestResponse("listing", listingCreateModel, e, "Listing has errors"));
      }
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Response> updateListing ( @PathVariable("id") UUID id,
                                                   @Valid     @RequestBody ListingCreateModel listingCreateModel
                                                  //   , Authentication authentication
                                                  ) {
        Response response=new  Response();
        try{
            if( id==null || !listingCreateModel.getId().toString().equals(id.toString())){
                return ResponseEntity.notFound().build();
            }

            UUID result= listingService.updateListing(modelMapper.map(listingCreateModel, ListingServiceModel.class));  return ResponseEntity.ok(response
                    .setOkRequestResponse("id",result,"Listing updated"));
        }catch (Exception e) {

            return ResponseEntity.ok(response
                    .setBadRequestResponse("listing", listingCreateModel, e, "Listing has errors"));
        }
    }
}
