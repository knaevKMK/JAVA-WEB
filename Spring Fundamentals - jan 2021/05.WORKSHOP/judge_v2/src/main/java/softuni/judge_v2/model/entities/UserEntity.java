package softuni.judge_v2.model.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
public class UserEntity extends BaseEntity {


    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(name = "email",unique = true, nullable = false)
    private String email;

    @Column(name="git", nullable = false)
    private String git;
    @ManyToOne
    private RoleEntity role;
}
