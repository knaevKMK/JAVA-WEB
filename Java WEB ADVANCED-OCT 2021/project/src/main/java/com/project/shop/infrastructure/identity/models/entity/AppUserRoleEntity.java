package com.project.shop.infrastructure.identity.models.entity;

import com.project.shop.infrastructure.identity.models.enums.AppUserRoleEnum;
import com.project.shop.model.entity.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "user_roles")
public class AppUserRoleEntity extends BaseEntity {
    private AppUserRoleEnum role;

    public AppUserRoleEntity() {
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
}
