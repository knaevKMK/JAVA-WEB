package com.project.shop.infrastructure.identity.DAO;

import com.project.shop.infrastructure.identity.models.view.JwtResponse;
import com.project.shop.infrastructure.identity.models.binding.LoginRequest;
import com.project.shop.infrastructure.identity.service.IdentityService;
import javassist.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class LoginHandlerImpl implements LoginHandler {

    private final ModelMapper modelMapper;
    private final IdentityService appUserService;

    public LoginHandlerImpl(ModelMapper modelMapper, IdentityService appUserService) {
        this.modelMapper = modelMapper;
        this.appUserService = appUserService;
    }

    @Override
    public JwtResponse login(LoginRequest request) throws NotFoundException {
        //  validate username, email,confirm password

        JwtResponse jwtToken = this.appUserService.login(request.getUsername(), request.getPassword());
        return jwtToken;

    }
}
