package org.proggers.backend.service.impl;

import org.proggers.backend.dao.AccountRepository;
import org.proggers.backend.domain.Account;
import org.proggers.backend.service.AccountService;
import org.proggers.backend.service.RequestDeniedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

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
        // TODO: Assertovi za lozinku, etc.
        return accountRepo.save(account);
    }

    @Override
    public boolean authenticateAccount(String username) {
        Optional<Account> optionalAccount = accountRepo.findByUsername(username);

        if (optionalAccount.isEmpty()) {
            throw new RequestDeniedException("No account with specified username.");
        }

        Account account = optionalAccount.get();

        account.authorize();

        accountRepo.save(account);

        return false;
    }
}
