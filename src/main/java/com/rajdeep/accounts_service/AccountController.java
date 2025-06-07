package com.rajdeep.accounts_service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping; // Import this

import java.net.URI;
import java.util.Optional;

@RestController
// MODIFICATION: By adding @RequestMapping at the class level, you define a base path
// for all endpoints in this controller. Now, all mappings inside this class
// will automatically start with "/accounts".
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    // The path is now simpler because "/accounts" is already defined at the class level.
    // It combines with the class-level mapping to become "/accounts/{accountId}".
    @GetMapping("/{accountId}")
    public ResponseEntity<Account> getAccountDetails(@PathVariable String accountId) {
        Optional<Account> account = accountService.findAccountById(accountId);
        return account.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // This path is now just "/", which combines with the class-level mapping
    // to become "/accounts".
    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        Account createdAccount = accountService.createAccount(account);
        return ResponseEntity
                .created(URI.create("/accounts/" + createdAccount.getAccountID()))
                .body(createdAccount);
    }
}