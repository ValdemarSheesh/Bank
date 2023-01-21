package com.example.Bank.repo;

import com.example.Bank.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query("SELECT C from Client C where C.phoneNumber = :phoneNumber")
    Client findByPhoneNumber(@Param("phoneNumber") Integer phoneNumber);
}
