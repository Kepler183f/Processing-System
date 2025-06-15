package com.rajdeep.accounts_service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List; // Add this import

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
    // Add this method to find accounts by ownerID
    List<Account> findByOwnerID(String ownerID);
}
