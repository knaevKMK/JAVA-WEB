package com.project.shop.infrastructure.identity.service;

import com.project.shop.infrastructure.identity.models.AppUserRoleEntity;
import com.project.shop.infrastructure.identity.models.AppUserRoleEnum;

public interface AppUserRoleService {
    void initializeRoles();
    AppUserRoleEntity getUserRole(AppUserRoleEnum role);
}
