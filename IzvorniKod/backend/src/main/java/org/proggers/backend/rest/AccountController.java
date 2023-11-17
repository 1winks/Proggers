package org.proggers.backend.rest;

import org.proggers.backend.domain.Account;
import org.proggers.backend.dto.RegistrationUserDTO;
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

    @PostMapping("/register")
    public Account registerAccount(@RequestBody RegistrationUserDTO regData) {
        return accountService.register(regData);
    }

    @PostMapping("/auth")
    public boolean authenticateAccount(@RequestBody String username) {
        return accountService.authenticate(username);
    }

    @PostMapping("/remove")
    public boolean removeAccount (@RequestBody String username) {
        return accountService.remove(username);
    }

}
