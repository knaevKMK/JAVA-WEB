package com.project.shop.infrastructure.identity;

import com.project.shop.infrastructure.identity.DAO.LoginHandler;
import com.project.shop.infrastructure.identity.DAO.RegisterHandler;
import com.project.shop.infrastructure.identity.models.JwtResponse;
import com.project.shop.infrastructure.identity.models.LoginRequest;
import com.project.shop.infrastructure.identity.models.RegisterRequest;
import com.project.shop.model.Response;
import javassist.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public ResponseEntity<Response> register(@Valid @RequestBody RegisterRequest request) {
        Response response=new  Response();

        try{
        String register = registerHandler.register(request);
            return ResponseEntity.ok(response
                    .setOkRequestResponse("register",register,"Successful registration "));
        }catch (Exception e) {
            request.setPassword(null)
            .setConfirmPassword(null);
            return ResponseEntity.ok(response
                    .setBadRequestResponse("register", request, e, "un-success registration"));
        }
    }
    @PostMapping("/login")
    public ResponseEntity<Response> login(@Valid @RequestBody LoginRequest request)  {
        Response response=new  Response();
        try{
            JwtResponse login = loginHandler.login(request);
            return ResponseEntity.ok(response
                    .setOkRequestResponse("login",login,"Successful Sing-in "));
        }catch (Exception e){
            request.setPassword(null);
            return ResponseEntity.ok(response
                    .setBadRequestResponse("login",  request,e,"un-success login"));
        }
    }

    @GetMapping("/confirm")
    public String confirm(@RequestParam("token") String token) {
        return registerHandler.confirmToken(token);
    }
    @GetMapping("/logout")
    public ResponseEntity<Response> logout(){
      Response response  =new  Response();
      response=response.setOkRequestResponse("login","Success","Successful Log Out ");
        return ResponseEntity.ok(response);
    }
}
