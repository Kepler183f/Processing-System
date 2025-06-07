package com.rajdeep.accounts_service;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Account {

    @Id
    private String accountID;
    private String ownerID;
    private String accountType;
    private Double balance;

    public Account()
    {

    }

    public Account(String accountID, String ownerId, String accountType, Double balance)
    {
        this.accountID = accountID;
        this.ownerID = ownerId;
        this.accountType = accountType;
        this.balance = balance;
    }

    public String getAccountID()
    {
        return accountID;
    }

    public void setAccountID(String accountID)
    {
        this.accountID = accountID;
    }

    public String getOwnerID()
    {
        return ownerID;
    }

    public void setOwnerID(String ownerID)
    {
        this.ownerID = ownerID;
    }

    public String getAccountType()
    {
        return accountType;
    }

    public void setAccountType(String accountType)
    {
        this.accountType = accountType;
    }

    public Double getBalance()
    {
        return balance;
    }

    public void setBalance(Double balance)
    {
        this.balance = balance;
    }



}
