package com.project.shop.identityArea.repository;

import com.project.shop.identityArea.models.entity.UserRole;
import com.project.shop.identityArea.models.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface AppUserRoleRepository extends JpaRepository<UserRole, UUID> {
    UserRole findByRole(RoleEnum role);
}
