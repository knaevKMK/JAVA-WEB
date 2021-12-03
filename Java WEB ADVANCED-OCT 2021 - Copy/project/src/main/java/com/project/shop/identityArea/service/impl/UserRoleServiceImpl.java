package com.project.shop.identityArea.service.impl;

import com.project.shop.identityArea.models.entity.UserRole;
import com.project.shop.identityArea.models.enums.RoleEnum;
import com.project.shop.identityArea.repository.AppUserRoleRepository;
import com.project.shop.identityArea.service.UserRoleService;
import com.project.shop.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserRoleServiceImpl extends BaseServiceImpl<UserRole> implements UserRoleService {
    private final AppUserRoleRepository appUserRoleRepository;


    public UserRoleServiceImpl(AppUserRoleRepository appUserRoleRepository) {
        this.appUserRoleRepository = appUserRoleRepository;
    }

@Override
    public void initializeRoles() {

        if (appUserRoleRepository.count() == 0) {
            Arrays.stream(RoleEnum.values())
                    .forEach(enumRole->{
                        UserRole userRole = new UserRole();
                        userRole.setRole(enumRole)
                                .setAuthority(enumRole.name());

                        appUserRoleRepository.saveAndFlush(userRole);
                    });
        }
    }
    @Override
    public UserRole getUserRole(RoleEnum role) {
        return appUserRoleRepository.findByRole(role);
    }

}
