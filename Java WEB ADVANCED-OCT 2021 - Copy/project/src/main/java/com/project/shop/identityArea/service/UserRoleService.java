package com.project.shop.identityArea.service;

import com.project.shop.identityArea.models.entity.UserRole;
import com.project.shop.identityArea.models.enums.RoleEnum;

public interface UserRoleService {
    void initializeRoles();
    UserRole getUserRole(RoleEnum role);
}
