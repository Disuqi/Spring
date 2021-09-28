package com.example.demo.services;
import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.Service;
import com.example.demo.entities.Account;

@Service
public class AccountService {
    private List<Account> accounts = new ArrayList<>();

    public Account addAccount(Account account) {
        // Add new Account
        this.accounts.add(account);
        // Return last added Account from List
        return this.accounts.get(this.accounts.size() - 1);
    }

    public List<Account> getAllAccounts() {
        // Return the whole List
        return this.accounts;
    }

    public Account updateAccount(int id, Account account) {
        // Remove existing Account with matching 'id'
        this.accounts.remove(id);
        // Add new Account in its place
        this.accounts.add(id, account);
        // Return updated Account from List
        return this.accounts.get(id);
    }

    public Account removeAccount(int id) {
        // Remove Account and return it
        return this.accounts.remove(id);
    }
}
