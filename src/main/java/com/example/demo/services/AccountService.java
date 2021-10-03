package com.example.demo.services;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entities.*;
import com.example.demo.exceptions.AccountNotFoundException;
import com.example.demo.repo.AccountRepo;
import org.modelmapper.ModelMapper;

@Service
public class AccountService {
    @Autowired
    private AccountRepo repo;
    @Autowired
    private ModelMapper mapper;

    public AccountDTO addAccount(Account account) {
        Account saved = this.repo.save(account);
        return this.mapToDTO(saved);
    }

    public List<AccountDTO> getAllAccounts() {
        return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public AccountDTO updateAccount(long id, Account account) {
        Optional<Account> existingOptional = this.repo.findById(id);
        Account existing = existingOptional.get();
        existing.setAccountNumber(account.getAccountNumber());
        existing.setName(account.getName());
        Account updated = this.repo.save(existing);
        return this.mapToDTO(updated);
    }

    public boolean removeAccount(long id) {
        this.repo.deleteById(id);
        boolean exists = this.repo.existsById(id);
        return !exists;
    }

    public AccountDTO getAccount(long id){
        Account existing = this.repo.findById(id).orElseThrow(AccountNotFoundException::new);
        return mapToDTO(existing);
    }

    private AccountDTO mapToDTO(Account account) {
        return this.mapper.map(account, AccountDTO.class);
    }
}
