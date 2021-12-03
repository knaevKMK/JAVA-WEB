package com.project.shop.identityArea.models.entity;

import com.project.shop.model.entity.Account;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "users")
public class UserEntity implements UserDetails {

    private UUID id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private Collection<AppUserRoleEntity> authorities;
    private boolean isAccountNonLocked = false;
    private boolean isEnabled = false;
    private boolean isAccountNonExpired;
    private boolean isCredentialsNonExpired;

    private Account account;

    public UserEntity() {
    }

    public UserEntity(String firstName,
                      String lastName,
                      String username,
                      String email,
                      String password,
                      Set<AppUserRoleEntity> appUserRoleEnum) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.authorities = appUserRoleEnum;
    }

    @Id
    @GeneratedValue(generator = "uuid-string")
    @GenericGenerator(name = "uuid-string", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, columnDefinition = "VARBINARY(16)")
    public UUID getId() {
        return id;
    }


    public UserEntity setId(UUID id) {
        this.id = id;
        return this;
    }

    @Column(nullable = false, length = 25)
    public String getFirstName() {
        return firstName;
    }

    @Column(nullable = false, length = 25)
    public String getLastName() {
        return lastName;
    }

    @Column(nullable = false, unique = true, length = 30)
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Column(nullable = false, unique = true, length = 30)
    public String getEmail() {
        return email;
    }

    @Override
    @ManyToMany(fetch = FetchType.EAGER)
    public Collection<AppUserRoleEntity> getAuthorities() {
        return this.authorities;
    }

    @Column(nullable = false)
    public String getPassword() {
        return this.password;
    }
    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    @Column(name = "active")
    public boolean isEnabled() {
        return this.isEnabled;
    }

    @OneToOne(optional = false)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    public Account getAccount() {
        return account;
    }

    //setters
    public UserEntity setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserEntity setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserEntity setUsername(String userName) {
        this.username = userName;
        return this;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserEntity setAuthorities(Collection<AppUserRoleEntity> role) {
        this.authorities = role;
        return this;
    }

    public UserEntity setAccountNonLocked(boolean accountNonLocked) {
        isAccountNonLocked = accountNonLocked;
        return this;
    }

    public UserEntity setEnabled(boolean enabled) {
        isEnabled = enabled;
        return this;
    }

    public UserEntity setAccount(Account appUser) {
        this.account = appUser;
        return this;
    }

    public UserEntity setAccountNonExpired(boolean accountNonExpired) {
        isAccountNonExpired = accountNonExpired;
        return this;
    }

    public UserEntity setCredentialsNonExpired(boolean credentialsNonExpired) {
        isCredentialsNonExpired = credentialsNonExpired;
        return this;
    }
}
