package spring_fundametals.mobilele.model.entites;


import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {

    private String username;
    private String password;
    private String firstName;
    private String lastName;

    private boolean isActive;


//    @OneToMany

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserRoleEntity getUserRoles() {
        return userRoles;
    }

    public UserEntity setUserRoles(UserRoleEntity userRoles) {
        this.userRoles = userRoles;
        return this;
    }
//    @ManyToMany
//    private List<UserRoleEntity> userRoles;

    @ManyToOne
    private UserRoleEntity userRoles;


    private String imageUrl;

    public String getUsername() {
        return username;
    }

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserEntity setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserEntity setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public boolean isActive() {
        return isActive;
    }

    public UserEntity setActive(boolean active) {
        isActive = active;
        return this;
    }

//    public List<UserRoleEntity> getUserRoles() {
//        return userRoles;
//    }
//
//    public UserEntity setUserRoles(List<UserRoleEntity> userRoles) {
//        this.userRoles = userRoles;
//        return this;
//    }

    public String getImageUrl() {
        return imageUrl;
    }

    public UserEntity setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
}
