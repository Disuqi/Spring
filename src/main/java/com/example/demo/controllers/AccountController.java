package com.example.demo.controllers;

import java.util.List;

import com.example.demo.entities.*;
import com.example.demo.services.AccountService;

import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {
    private AccountService service;

    public AccountController(AccountService service){
        this.service = service;
    }


    @PostMapping("/create")
    public AccountDTO addAccount(@RequestBody Account account){
        return this.service.addAccount(account);
    }

    @GetMapping("/getAll")
    public List<AccountDTO> getAllAccounts() {
        return this.service.getAllAccounts();
    }

    @PutMapping("/update")
    public AccountDTO updateAccount(@PathVariable long id, @RequestBody Account account){
        return this.service.updateAccount(id, account);
    }
    @DeleteMapping("/delete/{id}")
    public boolean removeAccount(@PathVariable long id){
        return this.service.removeAccount(id);
    }
    
}
