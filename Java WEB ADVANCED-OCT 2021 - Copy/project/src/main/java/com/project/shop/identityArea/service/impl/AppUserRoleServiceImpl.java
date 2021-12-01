package com.project.shop.identityArea.service.impl;

import com.project.shop.identityArea.models.entity.AppUserRoleEntity;
import com.project.shop.identityArea.models.enums.AppUserRoleEnum;
import com.project.shop.identityArea.repository.AppUserRoleRepository;
import com.project.shop.identityArea.service.AppUserRoleService;
import com.project.shop.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class AppUserRoleServiceImpl extends BaseServiceImpl<AppUserRoleEntity> implements AppUserRoleService {
    private final AppUserRoleRepository appUserRoleRepository;


    public AppUserRoleServiceImpl(AppUserRoleRepository appUserRoleRepository) {
        this.appUserRoleRepository = appUserRoleRepository;
    }

@Override
    public void initializeRoles() {

        if (appUserRoleRepository.count() == 0) {
            Arrays.stream(AppUserRoleEnum.values())
                    .forEach(enumRole->{
                        AppUserRoleEntity userRole = new AppUserRoleEntity();
                        userRole=this.onCreate(userRole.setRole(enumRole));
                        appUserRoleRepository.saveAndFlush(userRole);
                    });
        }
    }
    @Override
    public AppUserRoleEntity getUserRole(AppUserRoleEnum role) {
        return appUserRoleRepository.findByRole(role);
    }

}
