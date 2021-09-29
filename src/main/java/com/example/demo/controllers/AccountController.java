package com.example.demo.controllers;
import java.util.List;

import javax.websocket.server.PathParam;
import com.example.demo.entities.Account;
import com.example.demo.services.AccountService;

import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {
    private AccountService service;

    public AccountController(AccountService service){
        this.service = service;
    }


    @PostMapping("/create")
    public Account addAccount(@RequestBody Account account){
        return this.service.addAccount(account);
    }

    @GetMapping("/getAll")
    public List<Account> getAll() {
        return this.service.getAllAccounts();
    }

    @PutMapping("/update")
    public Account updateAccount(@PathVariable long id, @RequestBody Account account){
        return this.service.updateAccount(id, account);
    }
    @DeleteMapping("/delete/{id}")
    public boolean removeAccount(@PathVariable long id){
        return this.service.removeAccount(id);
    }
    
}
