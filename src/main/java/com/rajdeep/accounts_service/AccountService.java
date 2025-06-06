package com.rajdeep.accounts_service;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.Optional;

@Service
public class AccountService {

    // Our temporary, in-memory database. A Map of AccountID -> Account Object.
    private static final Map<String, Account> FAKE_DATABASE = Map.of(
            "123", new Account("123", "CUST-456", "CHECKING", 5450.75),
            "456", new Account("456", "CUST-789", "SAVINGS", 12345.00)
    );

    // Business logic to find an account by its ID
    public Optional<Account> findAccountById(String accountId) {
        return Optional.ofNullable(FAKE_DATABASE.get(accountId));
    }
}
