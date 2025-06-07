package com.rajdeep.accounts_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.UUID;
@Service
public class AccountService {


    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository)
    {
        this.accountRepository = accountRepository;

    }



    // Business logic to find an account by its ID
    public Optional<Account> findAccountById(String accountId) {
        return accountRepository.findById(accountId);
    }

    public Account createAccount(Account newAccount)
    {
        String newAccountId = UUID.randomUUID().toString();
        newAccount.setAccountID(newAccountId);

        // The save method handles creating the new record in the database
        return accountRepository.save(newAccount);
    }

}
