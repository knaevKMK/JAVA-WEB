package softuni.judge_v2.model.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import softuni.judge_v2.model.entities.RoleEntity;


@NoArgsConstructor
@Getter
@Setter
public class UserServiceModel {

    private String username;


    private String password;

    private String email;

    private String git;
   private RoleEntity role;
}
