package org.proggers.backend.service;


import org.proggers.backend.domain.Account;
import org.proggers.backend.dto.RegistrationUserDTO;

import java.util.List;

public interface AccountService {

    List<Account> list();

    Account register(RegistrationUserDTO regData);

    boolean authenticate(String username);

    boolean remove(String username);
}
