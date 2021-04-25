package registration.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import registration.repository.AppUserRepository;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {
    private static final  String ERR_MSG_USER_NOT_FOUND= "User with email: %s does not exist!";
    private final AppUserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return repo.findAppUserByEmail(email).orElseThrow(()->new UsernameNotFoundException(String.format(ERR_MSG_USER_NOT_FOUND,email)));
    }
}
