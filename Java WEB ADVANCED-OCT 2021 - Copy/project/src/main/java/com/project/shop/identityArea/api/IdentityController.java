package com.project.shop.identityArea.api;

import com.project.shop.identityArea.request.LoginHandler;
import com.project.shop.identityArea.request.RegisterHandler;
import com.project.shop.identityArea.models.entity.UserEntity;
import com.project.shop.identityArea.models.view.JwtResponse;
import com.project.shop.identityArea.models.binding.LoginRequest;
import com.project.shop.identityArea.models.binding.RegisterRequest;
import com.project.shop.identityArea.models.view.UserDetailsView;
import com.project.shop.model.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
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
                    .setOkRequestResponse("confirm",register,"Successful registration "));
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
    @GetMapping("/user")
    public ResponseEntity<Response> getUserData(Authentication authentication) {
       UserDetailsView user= null;
       if (authentication!=null){
           UserEntity _user=(UserEntity) authentication.getPrincipal();
           user=new UserDetailsView(_user.getUsername(),_user.getFirstName()+" "+_user.getLastName());
       }

        Response response  =new  Response();
        response=response.setOkRequestResponse("user",user ,"UserData");
        return ResponseEntity.ok(response);
    }
    @GetMapping("/confirm")
    public ResponseEntity<Response> confirm(@RequestParam("token") String token) {
        Response response  =new  Response();
        response=response.setOkRequestResponse("confirmed", registerHandler.confirmToken(token),"Successful confirmed");
        return ResponseEntity.ok(response);
    }
    @GetMapping("/logout")
    public ResponseEntity<Response> logout(){
      Response response  =new  Response();
      response=response.setOkRequestResponse("logout",true,"Successful Log Out ");
        return ResponseEntity.ok(response);
    }
}
