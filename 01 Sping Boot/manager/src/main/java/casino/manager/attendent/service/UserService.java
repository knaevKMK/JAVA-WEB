package casino.manager.attendent.service;

import casino.manager.attendent.entity.User;
import casino.manager.attendent.repository.UserRepository;
//import com.javadevjournal.system.exception.UserAlreadyExistException;
//import com.javadevjournal.user.jpa.data.UserEntity;
//import com.javadevjournal.user.jpa.repository.UserRepository;
//import com.javadevjournal.web.data.user.UserData;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service("userService")
public class UserService {
    @Autowired
    private UserRepository userRepository;

   // @Autowired
    PasswordEncoder passwordEncoder;


    public void register(User user) {
        if(isExistUser(user)){
         //   throw new NullPointerException("User already exist with this email");
        }

    User newUser = new User();
    BeanUtils.copyProperties(user,newUser);
    encodePassword(newUser,user);
    this.userRepository.save(newUser);
    }

    private boolean isExistUser(User user) {
        return this.userRepository.getUserByEmail(user.getEmail()) != null ||
                this.userRepository.getUserByUsername(user.getUsername()) != null;
    }

    private void encodePassword(User newUser, User user) {
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
    }


}
