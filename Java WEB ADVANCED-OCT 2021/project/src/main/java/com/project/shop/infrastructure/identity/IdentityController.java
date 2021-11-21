package com.project.shop.infrastructure.identity;

import com.project.shop.infrastructure.identity.DAO.LoginHandler;
import com.project.shop.infrastructure.identity.DAO.RegisterHandler;
import com.project.shop.infrastructure.identity.models.JwtResponse;
import com.project.shop.infrastructure.identity.models.LoginRequest;
import com.project.shop.infrastructure.identity.models.RegisterRequest;
import com.project.shop.model.Response;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("api/identity")
public class IdentityController {
    private final RegisterHandler registerHandler;
    private final LoginHandler loginHandler;

    public IdentityController(RegisterHandler registerHandler, LoginHandler loginHandler) {
        this.registerHandler = registerHandler;
        this.loginHandler = loginHandler;
    }


    @PostMapping("/register")
    public ResponseEntity<Response> register(@RequestBody RegisterRequest request) {
        String register = registerHandler.register(request);
        return ResponseEntity.ok(Response
                .builder()
                .timeStamp(LocalDateTime.now())
                .data(Map.of("register", register))
                .message("Successful registration ")
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .build()
        );
    }
    @PostMapping("/login")
    public ResponseEntity<Response> login(@RequestBody LoginRequest request) throws NotFoundException {
        JwtResponse login = loginHandler.login(request);
        return ResponseEntity.ok(Response
                .builder()
                .timeStamp(LocalDateTime.now())
                .data(Map.of("login", login))
                .message("Successful Sing-in ")
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .build()
        );
    }
    @GetMapping("/confirm")
    public String confirm(@RequestParam("token") String token) {
        return registerHandler.confirmToken(token);
    }
}
