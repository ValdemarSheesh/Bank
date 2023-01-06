package com.example.Bank.service;

import com.example.Bank.model.Bank;
import com.example.Bank.model.Client;
import com.example.Bank.model.Credit;

import java.util.List;

public interface BankService {
    List<Credit> getAllCredits();

    List<Client> getAllClients();
}
