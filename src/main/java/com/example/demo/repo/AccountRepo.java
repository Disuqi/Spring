package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entities.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long>{
}
