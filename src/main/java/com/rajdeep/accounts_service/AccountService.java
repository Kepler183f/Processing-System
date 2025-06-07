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

    // Add this new method to your AccountService class
    public Optional<Account> updateAccount(String accountId, Account updatedAccountDetails) {
        // First, check if an account with this ID even exists
        return accountRepository.findById(accountId)
                .map(existingAccount -> {
                    // If it exists, update its fields with the new details
                    existingAccount.setOwnerID(updatedAccountDetails.getOwnerID());
                    existingAccount.setAccountType(updatedAccountDetails.getAccountType());
                    existingAccount.setBalance(updatedAccountDetails.getBalance());
                    // Save the updated account back to the database
                    return accountRepository.save(existingAccount);
                });
    }


}
