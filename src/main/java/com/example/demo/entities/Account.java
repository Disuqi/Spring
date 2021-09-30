package com.example.demo.entities;
import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Account {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @Column (nullable = false, unique = true)
    private String accountNumber;
    
    public Account(String accountNumber, String name){
        this.accountNumber = accountNumber;
        this.name = name;
    }
    
}
