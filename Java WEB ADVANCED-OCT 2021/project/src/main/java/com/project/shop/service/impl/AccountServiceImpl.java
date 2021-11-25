package com.project.shop.service.impl;

import com.project.shop.model.entity.Account;
import com.project.shop.repository.AccountRepository;
import com.project.shop.service.AccountService;
import com.project.shop.service.BaseService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
@Service
public class AccountServiceImpl extends BaseServiceImpl<Account> implements AccountService {
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
      account=this.onCreate(account,account.getUsername());
        return   accountRepository.save(account);
    }

    @Override
    public Optional<Account> findByUsername(String username) {
        return accountRepository.findByUsername(username);
    }

    @Override
    public Optional<Account> getAccountByUserName(String username) {
        return accountRepository.findByUsername(username);
    }
}
