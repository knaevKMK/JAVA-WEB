package com.project.shop.identityArea.request;

import com.google.gson.Gson;
import com.project.shop.config.util.IOUtil;
import com.project.shop.config.util.IOUtilImpl;
import com.project.shop.constants.Paths;
import com.project.shop.identityArea.models.binding.RegisterRequest;
import com.project.shop.identityArea.models.entity.ConfirmationToken;
import com.project.shop.identityArea.models.entity.UserEntity;
import com.project.shop.identityArea.models.enums.RoleEnum;
import com.project.shop.identityArea.models.service.UserServiceModel;
import com.project.shop.identityArea.service.UserRoleService;
import com.project.shop.identityArea.service.ConfirmationTokenService;
import com.project.shop.identityArea.service.IdentityService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Set;

@Service
public class RegisterHandlerImpl implements RegisterHandler {

    private final IOUtil ioUtil;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final IdentityService identityService;
    private final UserRoleService userRoleService;
    // private final EmailValidator emailValidator;
    private final ConfirmationTokenService confirmationTokenService;

    public RegisterHandlerImpl(Gson gson, ModelMapper modelMapper, IdentityService identityService, UserRoleService userRoleService, ConfirmationTokenService confirmationTokenService) {
        this.ioUtil = new IOUtilImpl();
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.identityService = identityService;
        this.userRoleService = userRoleService;
        this.confirmationTokenService = confirmationTokenService;
    }

    @Override
    public String register(RegisterRequest model) {
        if (!model.getPassword().equals(model.getConfirmPassword())) {
            throw new IllegalArgumentException("Passwords not matched");
        }
        if (identityService.findByUsername(model.getUsername()).isPresent()) {
            throw new IllegalStateException("Username exist");
        }
        if (identityService.findByEmail(model.getEmail()).isPresent()) {
            throw new IllegalStateException("Username exist");
        }

        UserServiceModel account = modelMapper.map(model, UserServiceModel.class);
        account.setAuthorities(Set.of(userRoleService.getUserRole(RoleEnum.USER)));
        return identityService.registerUser(modelMapper.map(account, UserEntity.class));
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

        identityService.enableAccount(confirmationToken.getUser().getUsername());
        return "confirmed";

    }

    @Override
    public void seed5Accounts() throws IOException {
        try {
            String content = String.join("", ioUtil.readFile(Paths.USER_JSON_FILEPATH));

            Arrays.stream(gson.fromJson(content, RegisterRequest[].class))
                    .forEach(readUser -> {

                        try {
                            this.register(readUser);
                        } catch (Exception e) {

                        }
                    });
        } catch (Exception e) {
        }
    }
}
