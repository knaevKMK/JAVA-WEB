package com.project.shop.infrastructure.identity.service;

import com.project.shop.infrastructure.identity.models.AppUserRoleEntity;
import com.project.shop.infrastructure.identity.models.AppUserRoleEnum;
import com.project.shop.infrastructure.identity.repository.AppUserRoleRepository;
import com.project.shop.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserRoleServiceImpl extends BaseServiceImpl<AppUserRoleEntity> implements AppUserRoleService {
    private final AppUserRoleRepository appUserRoleRepository;


    public AppUserRoleServiceImpl(AppUserRoleRepository appUserRoleRepository) {
        this.appUserRoleRepository = appUserRoleRepository;
    }

@Override
    public void initializeRoles() {

        if (appUserRoleRepository.count() == 0) {
            AppUserRoleEntity adminRole = new AppUserRoleEntity();
            adminRole.setRole(AppUserRoleEnum.ADMIN);
            adminRole=this.onCreate(adminRole);

            AppUserRoleEntity userRole = new AppUserRoleEntity();
            userRole.setRole(AppUserRoleEnum.USER);

            appUserRoleRepository.saveAll(List.of(adminRole, userRole));
        }
    }
    @Override
    public AppUserRoleEntity getUserRole(AppUserRoleEnum role) {
        return appUserRoleRepository.findByRole(role);
    }

}
