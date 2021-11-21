package com.project.shop.infrastructure.identity.DAO;

import com.project.shop.infrastructure.identity.models.*;
import com.project.shop.infrastructure.identity.service.AppUserRoleService;
import com.project.shop.infrastructure.identity.service.ConfirmationTokenService;
import com.project.shop.infrastructure.identity.service.IdentityService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;

@Service
public class RegisterHandlerImpl implements RegisterHandler {

    private final ModelMapper modelMapper;
    private final IdentityService appUserService;
    private final AppUserRoleService appUserRoleService;
    // private final EmailValidator emailValidator;
    private final ConfirmationTokenService confirmationTokenService;

    public RegisterHandlerImpl(ModelMapper modelMapper, IdentityService appUserService, AppUserRoleService appUserRoleService, ConfirmationTokenService confirmationTokenService) {
        this.modelMapper = modelMapper;
        this.appUserService = appUserService;
        this.appUserRoleService = appUserRoleService;
        this.confirmationTokenService = confirmationTokenService;
    }

    @Override
    public String register(RegisterRequest model) {
        if (!model.getPassword().equals(model.getConfirmPassword())){
            throw new IllegalArgumentException("Passwords not matched");
        }
        if (appUserService.findByUsername(model.getUsername()).isPresent()){throw new IllegalStateException("Username exist");}
        if (appUserService.findByEmail(model.getEmail()).isPresent()){throw new IllegalStateException("Username exist");}

        AccountServiceModel account = modelMapper.map(model, AccountServiceModel.class);
        account.setRole(Set.of(appUserRoleService.getUserRole(AppUserRoleEnum.USER)));
        return appUserService.signUpUser(modelMapper.map(account,Account.class));
    }

    @Override
    @Transactional
    public String confirmToken(String token) {
        ConfirmationToken confirmationToken = this.confirmationTokenService
                .getToken(token)
                .orElseThrow(() -> new IllegalStateException("token not found"));
        if (confirmationToken.getConfirmAt() != null) {
            throw new IllegalStateException("token already confirmed");
        }
        LocalDateTime expiredAt = confirmationToken.getExpiredAt();
        if (expiredAt.isBefore(LocalDateTime.now())) {
            throw new IllegalStateException("token expired");
        }
        confirmationTokenService.setConfirmedAt(token);
        appUserService.confirmToken(confirmationToken.getAppUser().getEmail());
        return "confirmed";

    }
}
