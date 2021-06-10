package com.exam2.exam2.model.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="users")
@NoArgsConstructor
@Getter
@Setter
public class UserEntity extends BaseEntity{


    private String username;
    private String password;
    private String email;
}
