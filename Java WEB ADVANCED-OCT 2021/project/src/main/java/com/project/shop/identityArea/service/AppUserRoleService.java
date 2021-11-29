package com.project.shop.identityArea.service;

import com.project.shop.identityArea.models.entity.AppUserRoleEntity;
import com.project.shop.identityArea.models.enums.AppUserRoleEnum;

public interface AppUserRoleService {
    void initializeRoles();
    AppUserRoleEntity getUserRole(AppUserRoleEnum role);
}
