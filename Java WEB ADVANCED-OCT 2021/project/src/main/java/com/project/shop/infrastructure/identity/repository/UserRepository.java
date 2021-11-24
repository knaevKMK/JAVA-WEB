package com.project.shop.infrastructure.identity.repository;

import com.project.shop.infrastructure.identity.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Repository
@Transactional(readOnly = true)
public interface AppUserRepository extends JpaRepository<Account, UUID> {
    Optional<Account> findAppUserByEmail(String email);

    @Transactional
    @Modifying
    @Query("UPDATE Account a " +
            "SET a.active = TRUE WHERE a.email = ?1")
    int enableAppUser(String email);

    Optional<Account> findAppUserByUsername(String username);
}
