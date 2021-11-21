package com.project.shop.infrastructure.identity.models;

import com.project.shop.model.entity.Listing;
import com.project.shop.model.entity.Order;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "accounts")
public class Account  {

    private UUID id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private Set<AppUserRoleEntity> role;
    private boolean isLocked=false;
    private boolean isActive =false;
    private List<Listing> watchList=new ArrayList<>();
    private List<Listing> sellingList=new ArrayList<>();
    private List<Order> purchaseList = new ArrayList<>();

    public Account() {
    }
    public Account(String firstName,
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
    @GenericGenerator(name="uuid-string", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false,columnDefinition = "VARBINARY(16)")
    public UUID getId() {
        return id;
    }


    public Account setId(UUID id) {
        this.id = id;
        return this;
    }


    @ManyToMany
    @JoinTable(
            name = "buyer_watchings",
            joinColumns = @JoinColumn(name = "buyer_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "listing_id", referencedColumnName = "id"))
    public List<Listing> getWatchList() {
        return watchList;
    }

    public Account setWatchList(List<Listing> watchList) {
        this.watchList = watchList;
        return this;
    }
    @OneToMany(mappedBy = "seller")
    public List<Listing> getSellingList() {
        return sellingList;
    }

    public Account setSellingList(List<Listing> sellingList) {
        this.sellingList = sellingList;
        return this;
    }
    @OneToMany(mappedBy = "buyer")
    public List<Order> getPurchaseList() {
        return purchaseList;
    }

    public Account setPurchaseList(List<Order> purchaseList) {
        this.purchaseList = purchaseList;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
//    @Override
    public String getUsername() {
        return this.username;
    }
    public String getEmail() {
        return email;
    }
//    @Override
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

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//      return null;
//    }



// //   @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//  //  @Override
//    public boolean isAccountNonLocked() {
//        return !this.isLocked;
//    }
//
// //   @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }

    @Column(name="active")
    public boolean isActive() {
        return this.isActive;
    }


    //setters
    public Account setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Account setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Account setUsername(String userName) {
        this.username = userName;
        return this;
    }

    public Account setEmail(String email) {
        this.email = email;
        return this;
    }

    public Account setPassword(String password) {
        this.password = password;
        return this;
    }

    public Account setRole(Set<AppUserRoleEntity> role) {
        this.role = role;
        return this;
    }

    public Account setLocked(boolean locked) {
        isLocked = locked;
        return this;
    }

    public Account setActive(boolean active) {
        isActive = active;
        return this;
            }


}
