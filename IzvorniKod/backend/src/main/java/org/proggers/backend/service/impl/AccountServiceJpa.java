package org.proggers.backend.service.impl;

import org.proggers.backend.dao.AccountRepository;
import org.proggers.backend.domain.Account;
import org.proggers.backend.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AccountServiceJpa implements AccountService {
    @Autowired
    private AccountRepository accountRepo;

    @Override
    public List<Account> list() {
        return accountRepo.findAll();
    }

    @Override
    public Account createAccount(Account account) {
        // TODO: provjera za registraciju
        return accountRepo.save(account);
    }

    @Override
    public boolean authenticateAccount(String username) {
        // TODO: nesto sta god luka kaze
        return false;
    }
}
