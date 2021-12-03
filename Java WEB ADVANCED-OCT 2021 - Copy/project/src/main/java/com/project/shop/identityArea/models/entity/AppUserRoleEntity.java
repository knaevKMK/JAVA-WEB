package com.project.shop.identityArea.models.entity;

import com.project.shop.identityArea.models.enums.AppUserRoleEnum;
import com.project.shop.model.entity.BaseEntity;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "user_roles")
public class AppUserRoleEntity implements GrantedAuthority {
    private UUID id;
    private AppUserRoleEnum role;
    private String authority;

    public AppUserRoleEntity() {
    }

    @Id
    @GeneratedValue(generator = "uuid-string")
    @GenericGenerator(name = "uuid-string", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, columnDefinition = "VARBINARY(16)")
    public UUID getId() {
        return id;
    }

    public AppUserRoleEntity setId(UUID id) {
        this.id = id;
        return this;
    }

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    public AppUserRoleEnum getRole() {
        return role;
    }

    public AppUserRoleEntity setRole(AppUserRoleEnum role) {
        this.role = role;
        return this;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }

    public AppUserRoleEntity setAuthority(String authority) {
        this.authority = authority;
        return this;
    }
}
