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
    
    public String getAccountNumber(){
        return this.accountNumber;
    }

    public long getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }
    public void setAccountNumber(String accountNumber){
        this.accountNumber = accountNumber;
    }

    public void setId(long id){
        this.id = id;
    }

    public void setName(String name){
        this.name= name;
    }
}
