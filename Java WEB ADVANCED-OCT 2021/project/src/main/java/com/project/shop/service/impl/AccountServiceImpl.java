package com.project.shop.service;

import com.project.shop.model.entity.Account;
import com.project.shop.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
@Service
public class AccountServiceImpl implements AccountService {
    private  final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Optional<Account> getAccountById(UUID id) {
        return accountRepository.findById(id);
    }

    @Override
    public Account createAccount(Account account) {
      return   accountRepository.save(account);
    }
}
