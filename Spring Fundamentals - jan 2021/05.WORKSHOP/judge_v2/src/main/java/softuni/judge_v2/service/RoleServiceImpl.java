package softuni.judge_v2.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import softuni.judge_v2.model.entities.RoleEntity;
import softuni.judge_v2.model.entities.enums.RoleUserEnum;
import softuni.judge_v2.repository.RoleRepository;
import softuni.judge_v2.service.interfaces.RoleService;

import java.util.List;


@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository repository;

    @Override
    public void initRoles() {
        if (repository.count() == 0) {
            RoleEntity admin = new RoleEntity(RoleUserEnum.ADMIN);
            RoleEntity user = new RoleEntity(RoleUserEnum.USER);

            repository.saveAll(List.of(admin, user));
        }
    }

    @Override
    public RoleEntity findRole(RoleUserEnum roleUserEnum) {
        return repository.findByName((roleUserEnum)).orElse(null);
    }
}
