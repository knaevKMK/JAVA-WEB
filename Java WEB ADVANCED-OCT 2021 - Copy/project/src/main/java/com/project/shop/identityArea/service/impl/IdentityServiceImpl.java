package com.project.shop.identityArea.service.impl;

import com.project.shop.config.JWT.JwtTokenUtil;
import com.project.shop.identityArea.request.EmailSender;
import com.project.shop.identityArea.models.entity.UserRole;
import com.project.shop.identityArea.models.entity.ConfirmationToken;
import com.project.shop.identityArea.models.entity.UserEntity;
import com.project.shop.identityArea.models.enums.RoleEnum;
import com.project.shop.identityArea.models.view.JwtResponse;
import com.project.shop.identityArea.repository.UserRepository;
import com.project.shop.identityArea.service.UserRoleService;
import com.project.shop.identityArea.service.ConfirmationTokenService;
import com.project.shop.identityArea.service.IdentityService;
import com.project.shop.model.entity.Account;
import com.project.shop.service.AccountService;
import javassist.NotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class IdentityServiceImpl implements IdentityService {
    private static final String ERR_MSG_USER_NOT_FOUND = "User with email: %s does not exist!";

    private final UserRepository userRepository;

    private final UserRoleService userRoleService;
    private final AccountService accountService;
    private final ConfirmationTokenService confirmationTokenService;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final JwtTokenUtil jwtTokenUtil;

    private final EmailSender emailSender;


    public IdentityServiceImpl( UserRepository userRepository, UserRoleService userRoleService,
                               AccountService accountService, BCryptPasswordEncoder bCryptPasswordEncoder,
                               ConfirmationTokenService confirmationTokenService,
                               JwtTokenUtil jwtTokenUtil, EmailSender emailSender) {

        this.userRepository = userRepository;
        this.userRoleService = userRoleService;
        this.accountService = accountService;

        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.confirmationTokenService = confirmationTokenService;
        this.jwtTokenUtil = jwtTokenUtil;
        this.emailSender = emailSender;

    }

    @Override
    public String registerUser(UserEntity userEntity) {

        userEntity.setPassword(bCryptPasswordEncoder.encode(userEntity.getPassword()));
        userEntity.setAccount(accountService.createAccount(new Account(userEntity.getUsername())));
        this.userRepository.save(userEntity);

        String token = String.valueOf(UUID.randomUUID());
        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                userEntity);

        this.confirmationTokenService
                .saveConfirmationToken(confirmationToken);

        String link = "http://localhost:8080/api/identity/confirm?token=" + token;

        //todo config email send ->throw
       // this.enableAccount(userEntity.getEmail());
//    emailSender.send(
//            account.getEmail(),
//            buildEmail(account.getFirstName(), link));
        return link;
    }

    @Override
    public JwtResponse login(String username, String password) throws NotFoundException {

        Optional<UserEntity> account = this.findByUsername(username);
        if (account.isEmpty()) {
            throw new NotFoundException("Username does not exist");
        }
        boolean matches = bCryptPasswordEncoder.matches(password, account.get().getPassword());
        if (!matches){
            throw new NotFoundException("Try again");
        }


        return new JwtResponse(jwtTokenUtil.generateToken(account.get()));
    }

    @Override
    public Optional<UserEntity> findByUsername(String username) {
        return userRepository.findAppUserByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }

    @Override
    public Optional<UserEntity> findByEmail(String email) {
        return userRepository.findAppUserByEmail(email);
    }

    @Override
    public long getCount() {
        return userRepository.count();
    }

    @Override
    @Transactional
    public String enableAccount(String username) {

         userRepository.enableAppUser(username);
        return "confirmed";
    }

    @Override
    public void initializeUsersAndRoles() {
        userRoleService.initializeRoles();
        initializeUsers();
    }

    private void initializeUsers() {
        if (userRepository.count() == 0) {

            UserRole adminRole = userRoleService.getUserRole(RoleEnum.ADMIN);
            UserRole userRole = userRoleService.getUserRole(RoleEnum.USER);

            UserEntity admin = new UserEntity();
            admin
                    .setUsername("admin")
                    .setEmail("admin@buysell0.com")
                    .setAccount(accountService.createAccount(new Account("admin")))
                    .setPassword(bCryptPasswordEncoder.encode("owner"))
                    .setFirstName("Admin")
                    .setLastName("Owner")
                    .setEnabled(true);


            admin.setAuthorities(Set.of(adminRole, userRole));
            userRepository.save(admin);


        }
    }

    private String buildEmail(String name, String link) {
        return "<div style=\"font-family:Helvetica,Arial,sans-serif;font-size:16px;margin:0;color:#0b0c0c\">\n" +
                "\n" +
                "<span style=\"display:none;font-size:1px;color:#fff;max-height:0\"></span>\n" +
                "\n" +
                "  <table role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse;min-width:100%;width:100%!important\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
                "    <tbody><tr>\n" +
                "      <td width=\"100%\" height=\"53\" bgcolor=\"#0b0c0c\">\n" +
                "        \n" +
                "        <table role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse;max-width:580px\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"center\">\n" +
                "          <tbody><tr>\n" +
                "            <td width=\"70\" bgcolor=\"#0b0c0c\" valign=\"middle\">\n" +
                "                <table role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse\">\n" +
                "                  <tbody><tr>\n" +
                "                    <td style=\"padding-left:10px\">\n" +
                "                  \n" +
                "                    </td>\n" +
                "                    <td style=\"font-size:28px;line-height:1.315789474;Margin-top:4px;padding-left:10px\">\n" +
                "                      <span style=\"font-family:Helvetica,Arial,sans-serif;font-weight:700;color:#ffffff;text-decoration:none;vertical-align:top;display:inline-block\">Confirm your email</span>\n" +
                "                    </td>\n" +
                "                  </tr>\n" +
                "                </tbody></table>\n" +
                "              </a>\n" +
                "            </td>\n" +
                "          </tr>\n" +
                "        </tbody></table>\n" +
                "        \n" +
                "      </td>\n" +
                "    </tr>\n" +
                "  </tbody></table>\n" +
                "  <table role=\"presentation\" class=\"m_-6186904992287805515content\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse;max-width:580px;width:100%!important\" width=\"100%\">\n" +
                "    <tbody><tr>\n" +
                "      <td width=\"10\" height=\"10\" valign=\"middle\"></td>\n" +
                "      <td>\n" +
                "        \n" +
                "                <table role=\"presentation\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse\">\n" +
                "                  <tbody><tr>\n" +
                "                    <td bgcolor=\"#1D70B8\" width=\"100%\" height=\"10\"></td>\n" +
                "                  </tr>\n" +
                "                </tbody></table>\n" +
                "        \n" +
                "      </td>\n" +
                "      <td width=\"10\" valign=\"middle\" height=\"10\"></td>\n" +
                "    </tr>\n" +
                "  </tbody></table>\n" +
                "\n" +
                "\n" +
                "\n" +
                "  <table role=\"presentation\" class=\"m_-6186904992287805515content\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse;max-width:580px;width:100%!important\" width=\"100%\">\n" +
                "    <tbody><tr>\n" +
                "      <td height=\"30\"><br></td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "      <td width=\"10\" valign=\"middle\"><br></td>\n" +
                "      <td style=\"font-family:Helvetica,Arial,sans-serif;font-size:19px;line-height:1.315789474;max-width:560px\">\n" +
                "        \n" +
                "            <p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\">Hi " + name + ",</p><p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\"> Thank you for registering. Please click on the below link to activate your account: </p><blockquote style=\"Margin:0 0 20px 0;border-left:10px solid #b1b4b6;padding:15px 0 0.1px 15px;font-size:19px;line-height:25px\"><p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\"> <a href=\"" + link + "\">Activate Now</a> </p></blockquote>\n Link will expire in 15 minutes. <p>See you soon</p>" +
                "        \n" +
                "      </td>\n" +
                "      <td width=\"10\" valign=\"middle\"><br></td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "      <td height=\"30\"><br></td>\n" +
                "    </tr>\n" +
                "  </tbody></table><div class=\"yj6qo\"></div><div class=\"adL\">\n" +
                "\n" +
                "</div></div>";
    }
}
