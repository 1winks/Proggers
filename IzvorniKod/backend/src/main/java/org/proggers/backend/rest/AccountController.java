package org.proggers.backend.rest;

import org.proggers.backend.domain.Account;
import org.proggers.backend.domain.Book;
import org.proggers.backend.dto.LoginUserDTO;
import org.proggers.backend.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping("")
    public List<Account> listAccounts() {
        return accountService.list();
    }

    @PostMapping("/create")
    public Account createAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
    }

    @PostMapping("/authenticate")
    public boolean authenticateAccount(@RequestBody String username) {
        return accountService.authenticateAccount(username);
    }

}
