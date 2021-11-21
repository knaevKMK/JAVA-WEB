package com.project.shop.infrastructure.identity.service;

import com.project.shop.infrastructure.config.security.JwtTokenUtil;
import com.project.shop.infrastructure.identity.DAO.EmailSender;
import com.project.shop.infrastructure.identity.models.*;
import com.project.shop.infrastructure.identity.repository.AppUserRepository;
import javassist.NotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class IdentityServiceImpl  implements IdentityService {
    private static final String ERR_MSG_USER_NOT_FOUND = "User with email: %s does not exist!";

    private final AppUserRepository appUserRepository;
    private final AppUserRoleService appUserRoleService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;
    private final JwtTokenUtil jwtTokenUtil;
    private final EmailSender emailSender;

    public IdentityServiceImpl(AppUserRepository appUserRepository, AppUserRoleService appUserRoleService, BCryptPasswordEncoder bCryptPasswordEncoder, ConfirmationTokenService confirmationTokenService, JwtTokenUtil jwtTokenUtil, EmailSender emailSender) {
        this.appUserRepository = appUserRepository;
        this.appUserRoleService = appUserRoleService;

        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.confirmationTokenService = confirmationTokenService;
        this.jwtTokenUtil = jwtTokenUtil;
        this.emailSender = emailSender;
    }

//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        return appUserRepository.findAppUserByEmail(email)
//                .orElseThrow(() -> new UsernameNotFoundException(String.format(ERR_MSG_USER_NOT_FOUND, email)));
//    }
@Override
    public String signUpUser(Account account) {

        account.setPassword(bCryptPasswordEncoder.encode(account.getPassword()));
        this.appUserRepository.save(account);

        String token = String.valueOf(UUID.randomUUID());
        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                account);

    this.confirmationTokenService
            .saveConfirmationToken(confirmationToken);

    String link = "http://localhost:8080/api/identity/confirm?token=" + token;

    //todo config email send ->throw
//    emailSender.send(
//            account.getEmail(),
//            buildEmail(account.getFirstName(), link));
        return token;
    }

    @Override
    public JwtResponse login(String username, String password) throws NotFoundException {

        Optional<Account> account =this.findByUsername(username);
        if (account.isEmpty()){
            throw new NotFoundException("Username does not exist");
        }
        //todo match password
        return new JwtResponse(jwtTokenUtil.generateToken(account.get()));
    }

    @Override
    public Optional<Account> findByUsername(String username) {
        return appUserRepository.findAppUserByUsername(username);

    }

    @Override
    public Optional<Account> findByEmail(String email) {
        return appUserRepository.findAppUserByEmail(email);
    }

    @Override
    @Transactional
    public String confirmToken(String token) {
        ConfirmationToken confirmationToken = confirmationTokenService
                .getToken(token)
                .orElseThrow(() ->
                        new IllegalStateException("token not found"));

        if (confirmationToken.getConfirmAt() != null) {
            throw new IllegalStateException("email already confirmed");
        }

        LocalDateTime expiredAt = confirmationToken.getExpiredAt();

        if (expiredAt.isBefore(LocalDateTime.now())) {
            throw new IllegalStateException("token expired");
        }

        confirmationTokenService.setConfirmedAt(token);
        this.enableAccount(
                confirmationToken.getAppUser().getEmail());
        return "confirmed";
    }


    @Override
    public void initializeUsersAndRoles() {
       appUserRoleService.initializeRoles();
        initializeUsers();
    }



    private int enableAccount(String email) {
        return appUserRepository.enableAppUser(email);
    }




    private void initializeUsers() {
        if (appUserRepository.count() == 0) {

            AppUserRoleEntity adminRole = appUserRoleService.getUserRole(AppUserRoleEnum.ADMIN);
            AppUserRoleEntity userRole = appUserRoleService.getUserRole(AppUserRoleEnum.USER);

            Account admin = new Account();
            admin
                    .setUsername("admin")
                    .setEmail("admin@buysell0.com")
                    .setPassword(bCryptPasswordEncoder.encode("owner"))
                    .setFirstName("Admin")
                    .setLastName("Owner")
                    .setActive(true);


            admin.setRole(  Set.of(adminRole, userRole));
            appUserRepository.save(admin);


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
