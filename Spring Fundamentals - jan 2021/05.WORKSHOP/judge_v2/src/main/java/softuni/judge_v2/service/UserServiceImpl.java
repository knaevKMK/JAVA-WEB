package softuni.judge_v2.service;


import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.judge_v2.model.entities.UserEntity;
import softuni.judge_v2.model.entities.enums.RoleUserEnum;
import softuni.judge_v2.model.service.UserServiceModel;
import softuni.judge_v2.repository.UserRepository;
import softuni.judge_v2.service.interfaces.RoleService;
import softuni.judge_v2.service.interfaces.UserService;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final RoleService roleService;
    private ModelMapper mapper;

    @Override
    public void registerUser(UserServiceModel userServiceModel) {
        UserEntity user = mapper.map(userServiceModel, UserEntity.class);
        user.setRole(roleService.findRole(RoleUserEnum.USER));
    }
}
