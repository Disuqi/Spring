package com.example.demo.services;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.example.demo.entities.Account;
import com.example.demo.repo.AccountRepo;

@Service
public class AccountService {
    private AccountRepo repo;

    public AccountService(AccountRepo repo){
        this.repo = repo;
    }
    public Account addAccount(Account account) {
        return this.repo.save(account);
    }

    public List<Account> getAllAccounts() {
        return this.repo.findAll();
    }

    public Account updateAccount(long id, Account account) {
        Optional<Account> existingOptional = this.repo.findById(id);
        Account existing = existingOptional.get();
        existing.setAccountNumber(account.getAccountNumber());
        existing.setName(account.getName());
        return this.repo.save(existing);
    }

    public boolean removeAccount(long id) {
        this.repo.deleteById(id);
        boolean exists = this.repo.existsById(id);
        return !exists;
    }
}
