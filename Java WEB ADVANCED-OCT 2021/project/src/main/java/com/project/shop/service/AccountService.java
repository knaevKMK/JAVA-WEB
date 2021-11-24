package com.project.shop.service;

import com.project.shop.model.entity.Account;

import java.util.Optional;
import java.util.UUID;

public interface AccountService {
    Optional<Account> getAccountById(UUID id);
    Account createAccount(Account account);

    Optional<Account> findByUsername(String username);
}
