package com.project.shop.web;

import com.project.shop.identityArea.models.entity.UserEntity;
import com.project.shop.model.Response;
import com.project.shop.model.binding.FeedbackBindingModel;
import com.project.shop.model.binding.FeedbackLeftBindingModel;
import com.project.shop.model.binding.ListingCreateModel;
import com.project.shop.model.entity.Feedback;
import com.project.shop.model.service.ListingServiceModel;
import com.project.shop.model.view.FeedBackViewModel;
import com.project.shop.service.FeedBackService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("api/feedback")
public class FeedbackController {
    private final FeedBackService feedBackService;

    public FeedbackController(FeedBackService feedBackService) {
        this.feedBackService = feedBackService;
    }

    @GetMapping("/all")
    public ResponseEntity<Response> getAllListings(@RequestParam(required = false) String query,
                                                   @RequestParam(required = false, defaultValue = "0") int page,
                                                   @RequestParam(required = false, defaultValue = "30") int limit,
                                                   Authentication authentication) {

        List<FeedBackViewModel> feedbacks = feedBackService.getAll(authentication, query, page,limit);
        Response response = new Response();
        return ResponseEntity.ok(response
                .setOkRequestResponse("feebacks", feedbacks, "Feedbacks retrieved"));
    }

    @PostMapping("add")
    public ResponseEntity<Response> left( @RequestBody FeedbackLeftBindingModel model
            , Authentication authentication
    ) {
        Response response = new Response();
        try {
            if (authentication == null) {
                throw new UnsupportedOperationException("Login before left feedback");
            }
            UserEntity principal = (UserEntity) authentication.getPrincipal();

            var result = feedBackService.sendFeedBack(model, principal.getUsername());
            return ResponseEntity.ok(response
                    .setOkRequestResponse("left", result, "Listing created"));
        } catch (Exception e) {

            return ResponseEntity.ok(response
                    .setBadRequestResponse("left", false, e, e.getMessage()));
        }
    }
    @PutMapping("response/{id}")
    public ResponseEntity<Response> response(@RequestParam UUID id, @RequestBody FeedbackBindingModel model
            , Authentication authentication
    ) {
        Response response = new Response();
        try {
            if (id==null ){
                throw new NullPointerException("Invalid id");
            }
            if (authentication == null) {
                throw new UnsupportedOperationException("Login before left feedback");
            }
            UserEntity principal = (UserEntity) authentication.getPrincipal();

            var result = feedBackService.responseFeedBack(id,model, principal.getUsername());
            return ResponseEntity.ok(response
                    .setOkRequestResponse("left", result, "Listing created"));
        } catch (Exception e) {

            return ResponseEntity.ok(response
                    .setBadRequestResponse("left", false, e, e.getMessage()));
        }
    }
}
