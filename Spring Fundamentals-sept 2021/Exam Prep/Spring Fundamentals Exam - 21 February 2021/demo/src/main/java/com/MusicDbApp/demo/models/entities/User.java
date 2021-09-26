package com.MusicDbApp.demo.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collection;

@Entity
@Table(name="users")
public class User extends  BaseEntity{


    private String userName;
    private String fullName;
    private String Password;
    private String Email;
 //   private Collection<Album> albums;

    public User() {
    }
//@OneToMany
//    public Collection<Album> getAlbums() {
//        return albums;
//    }
//
//    public void setAlbums(Collection<Album> albums) {
//        this.albums = albums;
//    }

    @Column(name = "username", unique = true, nullable = false)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    @Column(name = "full_name", nullable = false)
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    @Column(name = "password", nullable = false)
    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
    @Column(name = "email", unique = true, nullable = false)
    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }


}
