package softuni.judge_v2.model.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import softuni.judge_v2.model.entities.enums.RoleUserEnum;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@Getter
@Setter
@NoArgsConstructor
public class RoleEntity extends BaseEntity {

   @Enumerated(EnumType.STRING)
    private RoleUserEnum name;

}
