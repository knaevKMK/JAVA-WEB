package com.project.shop.infrastructure.identity.models.entity;

import com.project.shop.model.entity.Account;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "users")
public class UserEntity {

    private UUID id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private Set<AppUserRoleEntity> role;
    private boolean isLocked = false;
    private boolean isActive = false;
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
        this.role = appUserRoleEnum;
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

    @Column(nullable = false, unique = true, length = 30)
    public String getEmail() {
        return email;
    }

    @Column(nullable = false)
    public String getPassword() {
        return this.password;
    }


    @ManyToMany(fetch = FetchType.EAGER)
    public Set<AppUserRoleEntity> getRole() {
        return role;
    }

    public boolean isLocked() {
        return isLocked;
    }

    @Column(name = "active")
    public boolean isActive() {
        return this.isActive;
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

    public UserEntity setRole(Set<AppUserRoleEntity> role) {
        this.role = role;
        return this;
    }

    public UserEntity setLocked(boolean locked) {
        isLocked = locked;
        return this;
    }

    public UserEntity setActive(boolean active) {
        isActive = active;
        return this;
    }

    @OneToOne(optional = false)
    @JoinColumn(name ="account_id" ,referencedColumnName = "id")
    public Account getAccount() {
        return account;
    }

    public UserEntity setAccount(Account appUser) {
        this.account = appUser;
        return this;
    }
}
