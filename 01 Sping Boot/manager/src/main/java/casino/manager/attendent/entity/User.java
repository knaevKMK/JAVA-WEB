package casino.manager.attendent.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User extends BaseEntity {

    @Column(nullable = false,unique = true,length = 45)
    private String email;
    @Column(nullable = false,unique = true,length = 20)
    private String username;
    @Column(nullable = false,length = 64)
    private String password;
    @Column(name="first_name",nullable = false,length = 20)
    private String firstName;
    @Column(name = "last_name",nullable = false,length = 20)
    private String lastName;


}
