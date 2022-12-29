package com.example.Bank.repo;

import com.example.Bank.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BankRepository extends JpaRepository<Bank, Long> {
    @Query("SELECT B from Bank B where B.name = :name")
    Bank findByName(@Param("name") String name);
}
