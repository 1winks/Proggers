package org.proggers.backend.service.impl;

import org.proggers.backend.dao.AccountRepository;
import org.proggers.backend.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.springframework.security.core.authority.AuthorityUtils.commaSeparatedStringToAuthorityList;

@Service
public class UserDetailsServiceJpa implements UserDetailsService {
    @Value("${backend.admin.password}")
    private String adminPasswordHash;

    @Autowired
    private AccountRepository accountRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username.equals("admin")) {
            return new User(
                    "admin",
                    adminPasswordHash,
                    commaSeparatedStringToAuthorityList("ROLE_ADMIN")
            );
        }

        Optional<Account> optionalAccount = accountRepo.findByUsername(username);
        if (optionalAccount.isEmpty()) {
            throw new UsernameNotFoundException("User not present in DB.");
        }

        Account account = optionalAccount.get();

        if (!account.isAuthorized()) {
            throw new UsernameNotFoundException("User not validated by site administrator.");
        }

        if (account.getSeller() == null) {
            throw new RuntimeException("User is not linked to a seller type.");
        }

        String role;

        switch (account.getSeller().getType()) {
            case RESELLER -> role = "ROLE_RESELLER";
            case PUBLISHER -> role = "ROLE_PUBLISHER";
            case ANTIQUARIAN -> role = "ROLE_ANTIQUARIAN";
            default -> throw new RuntimeException("Unexpected seller type");
        }

        return new User(
                account.getUsername(),
                account.getPassword(),
                commaSeparatedStringToAuthorityList(role)
        );
    }
}
