package org.proggers.backend.service;


import org.proggers.backend.domain.Account;

import java.util.List;

public interface AccountService {

    List<Account> list();

    Account createAccount(Account account);

    boolean authenticateAccount(String username);
}
