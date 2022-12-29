package com.example.Bank.service;

import com.example.Bank.model.Bank;

import java.util.List;

public interface BankService {
    Bank addBank(Bank bank);
    void deleteBank(long id);
    Bank getBankByName(String name);
    Bank editBank(Bank bank);
    List<Bank> getAllBank();
}
