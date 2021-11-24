package com.project.shop.infrastructure.identity.repository;

import com.project.shop.infrastructure.identity.models.entity.AppUserRoleEntity;
import com.project.shop.infrastructure.identity.models.enums.AppUserRoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface AppUserRoleRepository extends JpaRepository<AppUserRoleEntity, UUID> {
    AppUserRoleEntity findByRole(AppUserRoleEnum role);
}
