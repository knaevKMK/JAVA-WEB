package com.project.shop.identityArea.repository;

import com.project.shop.identityArea.models.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Repository
@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    Optional<UserEntity> findAppUserByEmail(String email);

    @Transactional
    @Modifying
    @Query("UPDATE UserEntity a " +
            "SET a.enabled = TRUE WHERE a.username = ?1")
    int enableAppUser(String email);

    Optional<UserEntity> findAppUserByUsername(String username);
}
