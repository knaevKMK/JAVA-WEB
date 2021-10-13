package exam.music.service.impl;

import exam.music.model.binding.UserLoginBindingModel;
import exam.music.model.entity.User;
import exam.music.model.service.UserServiceModel;
import exam.music.repository.UserRepository;
import exam.music.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper mapper) {
        this.userRepository = userRepository;
        this.modelMapper = mapper;
    }

    public UserServiceModel add(UserServiceModel model) {
        User user = modelMapper.map(model, User.class);
        User savedUser = userRepository.saveAndFlush(user);
        UserServiceModel _return= modelMapper.map(savedUser,UserServiceModel.class);
        return _return;
    }

    @Override
    public User getUser(UserServiceModel userModel) {
        if (userModel.getUsername()!=null){
            return  this.userRepository.findByUsername(userModel.getUsername()).orElse(null);

        }
        if (userModel.getEmail()!=null){
            return  this.userRepository.findByEmail(userModel.getEmail()).orElse(null);

        }
        return null;
    }

    @Override
    public UserServiceModel FindByUsername(UserLoginBindingModel model) {

        return  this.userRepository
                .findByUsername(model.getUsername())
                .map(user->modelMapper.map(user,UserServiceModel.class))
                .orElse(null);
    }
}