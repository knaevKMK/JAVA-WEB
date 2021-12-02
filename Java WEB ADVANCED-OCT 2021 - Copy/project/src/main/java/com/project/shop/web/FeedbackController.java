package com.project.shop.web;

import com.project.shop.identityArea.models.entity.UserEntity;
import com.project.shop.model.Response;
import com.project.shop.model.binding.FeedbackBindingModel;
import com.project.shop.model.binding.FeedbackLeftBindingModel;
import com.project.shop.model.view.FeedBackViewModel;
import com.project.shop.model.view.FeedbackInListVewModel;
import com.project.shop.service.FeedBackService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Response> getAll(@RequestParam(required = false) String query,
                                                   @RequestParam(required = false, defaultValue = "0") int page,
                                                   @RequestParam(required = false, defaultValue = "30") int limit,
                                                   Authentication authentication) {

        List<FeedbackInListVewModel> feedbacks = feedBackService.getAll(authentication, query, page,limit);
        Response response = new Response();
        return ResponseEntity.ok(response
                .setOkRequestResponse("feedbacks", feedbacks, "Feedbacks retrieved"));
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
                    .setOkRequestResponse("msg", result, "Feedback sent"));
        } catch (Exception e) {

            return ResponseEntity.ok(response
                    .setBadRequestResponse("msg", false, e, e.getMessage()));
        }
    }

}
