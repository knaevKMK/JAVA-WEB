package com.project.shop.web;

import com.project.shop.identityArea.models.entity.UserEntity;
import com.project.shop.model.Response;
import com.project.shop.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/payments")
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
    @GetMapping("/all")
    public ResponseEntity<Response> getAll() {
        Response response = new Response();
            return ResponseEntity.ok(response
                    .setOkRequestResponse("payments", paymentService.getAll(), "Payments retrieved"));
    }
}
