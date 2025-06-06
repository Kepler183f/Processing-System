package com.rajdeep.accounts_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

@RestController
public class AccountController {

    private final AccountService accountService;

    // Spring will automatically "inject" the AccountService instance here
    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/accounts/{accountId}")
    public ResponseEntity<Account> getAccountDetails(@PathVariable String accountId) {
        Optional<Account> account = accountService.findAccountById(accountId);

        // If the account is found, return it with a 200 OK status.
        // If not, return a 404 Not Found status.
        return account.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}