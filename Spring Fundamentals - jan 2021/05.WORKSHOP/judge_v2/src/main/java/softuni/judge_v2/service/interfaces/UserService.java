package softuni.judge_v2.service.interfaces;


import org.springframework.stereotype.Service;
import softuni.judge_v2.model.service.UserServiceModel;

@Service
public interface UserService {

    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);
}
