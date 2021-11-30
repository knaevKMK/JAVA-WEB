package com.project.shop.web;

import com.project.shop.identityArea.models.entity.UserEntity;
import com.project.shop.model.Response;
import com.project.shop.model.binding.MsgBindingModel;
import com.project.shop.model.service.MsgServiceModel;
import com.project.shop.model.view.MsgViewModel;
import com.project.shop.service.MessageService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("api/msg")
public class MessageController {
    private final MessageService messageService;
    private final ModelMapper modelMapper;

    public MessageController(MessageService messageService, ModelMapper modelMapper) {
        this.messageService = messageService;
        this.modelMapper = modelMapper;
    }
    @GetMapping("/all")
    public ResponseEntity<Response> getAll(@RequestParam(required = true) String query,
                                                   Authentication authentication) {
        Response response = new Response();
        try {
            if (authentication == null) {
                throw new UnsupportedOperationException("Login before send message");
            }
            UserEntity principal = (UserEntity) authentication.getPrincipal();
            var result= messageService.getMessages(principal.getUsername(),query);
            return ResponseEntity.ok(response
                    .setOkRequestResponse("msg", result, "Mail Box sent"));
        } catch (Exception e) {

            return ResponseEntity.ok(response
                    .setBadRequestResponse("msg", null, e, e.getMessage()));
        }
    }
    @PostMapping("/send")
    public ResponseEntity<Response> send( @RequestBody MsgBindingModel model
            , Authentication authentication
    ) {
        Response response = new Response();
        try {
            if (authentication == null) {
                throw new UnsupportedOperationException("Login before send message");
            }
            UserEntity principal = (UserEntity) authentication.getPrincipal();
            MsgServiceModel map = modelMapper.map(model, MsgServiceModel.class);

            var result = messageService.sendMessage(map,principal.getUsername());
            return ResponseEntity.ok(response
                    .setOkRequestResponse("msg", result, result));
        } catch (Exception e) {

            return ResponseEntity.ok(response
                    .setBadRequestResponse("msg", model, e, e.getMessage()));
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Response> getById(@PathVariable UUID id
    ) {
        Response response = new Response();
        try {
            MsgViewModel model = messageService.getMessageBiId(id);
            return ResponseEntity.ok(response
                    .setOkRequestResponse("msg", model, "Message  retrieved"));
        } catch (Exception e) {

            return ResponseEntity.ok(response
                    .setBadRequestResponse("id", id, e, e.getMessage()));
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteById(@PathVariable UUID id
            , Authentication authentication
    ) {
        Response response = new Response();
        try {
            if (authentication == null) {
                throw new IllegalStateException("You are not authorize to delete this msg");
            }
            UserEntity principal = (UserEntity) authentication.getPrincipal();
            boolean isDeleted = messageService.delete(id, principal.getUsername());
            return ResponseEntity.ok(response
                    .setOkRequestResponse("deleted", isDeleted, "Message deleted"));
        } catch (Exception e) {
            return ResponseEntity.ok(response
                    .setBadRequestResponse("deleted", false, e, e.getMessage()));
        }
    }
}
