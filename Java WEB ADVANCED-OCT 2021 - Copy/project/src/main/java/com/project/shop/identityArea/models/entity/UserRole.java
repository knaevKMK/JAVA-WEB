package com.project.shop.identityArea.models.entity;

import com.project.shop.identityArea.models.enums.RoleEnum;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "authorities")
public class UserRole implements GrantedAuthority {
    private UUID id;
    private RoleEnum role;
    private String authority;

    public UserRole() {
    }

    @Id
    @GeneratedValue(generator = "uuid-string")
    @GenericGenerator(name = "uuid-string", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, columnDefinition = "VARBINARY(16)")
    public UUID getId() {
        return id;
    }

    public UserRole setId(UUID id) {
        this.id = id;
        return this;
    }

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    public RoleEnum getRole() {
        return role;
    }

    public UserRole setRole(RoleEnum role) {
        this.role = role;
        return this;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }

    public UserRole setAuthority(String authority) {
        this.authority = authority;
        return this;
    }
}
