package org.proggers.backend.dao;

import org.proggers.backend.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;

public interface AccountRepository extends JpaRepository<Account, Long> {
    // TODO: Implement following methods

//    boolean isAuthorized (String username);
//
//    Set<Account> getUnauthorizedAccounts ();

    Optional<Account> findByUsername (String username);

    void removeAccountByUsername(String username);
}
