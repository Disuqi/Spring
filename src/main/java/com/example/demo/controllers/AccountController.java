package com.example.demo.controllers;

import java.util.List;

import com.example.demo.entities.*;
import com.example.demo.services.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {
    @Autowired
    private AccountService service;


    @PostMapping("/create")
    public AccountDTO addAccount(@RequestBody Account account){
        return this.service.addAccount(account);
    }

    @GetMapping("/getAll")
    public List<AccountDTO> getAllAccounts() {
        return this.service.getAllAccounts();
    }

    @GetMapping("/get/{id}")
    public AccountDTO getAccount(@PathVariable long id){
        return this.service.getAccount(id);
    }

    @PutMapping("/update/{id}")
    public AccountDTO updateAccount(@PathVariable long id, @RequestBody Account account){
        return this.service.updateAccount(id, account);
    }
    @DeleteMapping("/delete/{id}")
    public boolean removeAccount(@PathVariable long id){
        return this.service.removeAccount(id);
    }
    
}
