package com.example.demo.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountDTO {
    private long id;
    private String name;
    private String accountNumber;
    
    public AccountDTO(Account account){
    }
    
}
