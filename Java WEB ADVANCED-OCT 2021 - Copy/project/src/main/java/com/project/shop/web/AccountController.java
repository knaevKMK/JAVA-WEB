package com.project.shop.web;

import com.project.shop.identityArea.models.entity.UserEntity;
import com.project.shop.model.Response;
import com.project.shop.model.entity.Account;
import com.project.shop.model.view.AccountViewModel;
import com.project.shop.model.view.OwnAccountVewModel;
import com.project.shop.service.AccountService;
import com.project.shop.service.FeedBackService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/account")
public class AccountController {
    private final AccountService accountService;
    private final ModelMapper modelMapper;
    private final FeedBackService feedBackService;

    public AccountController(AccountService accountService, ModelMapper modelMapper, FeedBackService feedBackService) {
        this.accountService = accountService;

        this.modelMapper = modelMapper;
        this.feedBackService = feedBackService;
    }

    @GetMapping("/{username}")
    public ResponseEntity<Response> getUser(@PathVariable String username
            , Authentication authentication) {

        Response response = new Response();
        try {

            Account account = accountService.getAccountByUserName(username)
                    .orElseThrow(() -> new NullPointerException("User does not exist"));

     int stars=       feedBackService.getCountPositiveFeedbacksCount(username);
            if (authentication != null) {
                UserEntity principal = (UserEntity) authentication.getPrincipal();
                if (principal.getUsername().equals(username)) {
                    var model = modelMapper.map(account, OwnAccountVewModel.class);
                    model.setStars(stars);
                    model.setOwner(true);
                    model.setFirstName(principal.getFirstName()).setLastName(principal.getLastName());
                    return ResponseEntity.ok(response
                            .setOkRequestResponse("user", model, "Own User retrieved"));
                }
            }
            var model = modelMapper.map(account, AccountViewModel.class);
            model.setStars(stars);
            return ResponseEntity.ok(response
                    .setOkRequestResponse("user", model, "User retrieved"));
        } catch (Exception e) {
            return ResponseEntity.ok(response
                    .setBadRequestResponse("user", null, e, e.getMessage()));
        }
    }
}
