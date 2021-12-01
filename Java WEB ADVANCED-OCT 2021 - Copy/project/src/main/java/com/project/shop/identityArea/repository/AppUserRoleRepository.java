package com.project.shop.identityArea.repository;

import com.project.shop.identityArea.models.entity.AppUserRoleEntity;
import com.project.shop.identityArea.models.enums.AppUserRoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface AppUserRoleRepository extends JpaRepository<AppUserRoleEntity, UUID> {
    AppUserRoleEntity findByRole(AppUserRoleEnum role);
}
