package org.proggers.backend.service.impl;

import org.proggers.backend.dao.AccountRepository;
import org.proggers.backend.dao.SellerRepository;
import org.proggers.backend.domain.Account;
import org.proggers.backend.domain.Seller;
import org.proggers.backend.dto.RegistrationUserDTO;
import org.proggers.backend.service.AccountService;
import org.proggers.backend.service.RequestDeniedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceJpa implements AccountService {
    @Autowired
    private AccountRepository accountRepo;

    @Autowired
    private SellerRepository sellerRepo;

    @Autowired
    private PasswordEncoder pswdEncoder;

    @Override
    public List<Account> list() {
        return accountRepo.findAll();
    }

    @Override
    public Account register(RegistrationUserDTO regData) {
        // TODO: Server side assertovi za podatke u RegistrationData
        String password = regData.getPassword();

        Assert.notNull(password, "Password cant be empty");
        Assert.hasText(password, "Password cant be empty");

        regData.setPassword(pswdEncoder.encode(password));

        Account account = new Account(regData);
        Seller seller = new Seller(regData);

        account.setSeller(seller);

        sellerRepo.save(seller);
        return accountRepo.save(account);
    }

    @Override
    public boolean authenticate(String username) {
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
