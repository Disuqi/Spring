package com.example.demo;

import com.example.demo.entities.Account;
import com.example.demo.entities.AccountDTO;
import com.example.demo.repo.AccountRepo;
import com.example.demo.services.AccountService;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class AccountServiceUnitTest {
    @Autowired
    private AccountService service;

    @MockBean 
    private AccountRepo repo;
    
    @MockBean
    private ModelMapper mapper;

    @Test
    void testAddAccount(){
        Account accountA = new Account("123abc", "John");
        AccountDTO accountADTO = new AccountDTO(accountA);
        Mockito.when(this.repo.save(accountA)).thenReturn(accountA);
        Mockito.when(this.mapper.map(accountA, AccountDTO.class)).thenReturn(accountADTO);
        Assertions.assertThat(this.service.addAccount(accountA)).isEqualTo(accountADTO);
        Mockito.verify(this.repo, Mockito.times(1)).save(accountA);
        Mockito.verify(this.mapper, Mockito.times(1)).map(accountA, AccountDTO.class);
    }
}
