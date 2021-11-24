package com.project.shop.infrastructure.identity.service;

import com.project.shop.infrastructure.identity.models.entity.AppUserRoleEntity;
import com.project.shop.infrastructure.identity.models.enums.AppUserRoleEnum;

public interface AppUserRoleService {
    void initializeRoles();
    AppUserRoleEntity getUserRole(AppUserRoleEnum role);
}
