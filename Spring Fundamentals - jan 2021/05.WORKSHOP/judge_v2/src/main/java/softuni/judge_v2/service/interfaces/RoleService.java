package softuni.judge_v2.service.interfaces;

import softuni.judge_v2.model.entities.RoleEntity;
import softuni.judge_v2.model.entities.enums.RoleUserEnum;

public interface RoleService {
    void initRoles();
    RoleEntity findRole(RoleUserEnum roleUserEnum);
}
