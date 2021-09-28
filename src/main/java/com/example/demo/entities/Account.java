package com.example.demo.entities;
import javax.persistence.*;

@Entity
public class Account {

    @Column (nullable = false, unique = true)
    private String accountNumber;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    public Account(String accountNumber, String name){
        this.accountNumber = accountNumber;
        this.name = name;
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
