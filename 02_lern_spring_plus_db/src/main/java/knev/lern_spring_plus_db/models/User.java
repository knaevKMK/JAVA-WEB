package knev.lern_spring_plus_db.models;

import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.*;

import static javax.persistence.GenerationType.IDENTITY;

public class User implements UserDetails {

    public static final String ROLE_USER = "ROLE_USER";
    public static final String ROLE_ADMIN = "ROLE_ADMIN";

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @EqualsAndHashCode.Include
    private UUID id;


    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private Set<Role> roles;
    private boolean active=true;
    @Length(min = 8, max = 512)
    private String imageUrl;
    @OneToMany(mappedBy = "seller")

    private Collection<Offer> offers = new ArrayList<>();

    private Date created = new Date();
    private Date modified = new Date();
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return active;
    }

    @Override
    public boolean isAccountNonLocked() {
        return active;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return active;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }
}
