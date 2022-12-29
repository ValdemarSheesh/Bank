package com.example.Bank.service.impl;

import com.example.Bank.model.Bank;
import com.example.Bank.repo.BankRepository;
import com.example.Bank.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BankServiceImpl implements BankService {
    @Autowired
    private BankRepository bankRepository;

    @Override
    public Bank addBank(Bank bank) {
        return bankRepository.saveAndFlush(bank);
    }

    @Override
    public void deleteBank(long id) {
        bankRepository.deleteById(id);
    }

    @Override
    public Bank getBankByName(String name) {
        return bankRepository.findByName(name);
    }

    @Override
    public Bank editBank(Bank bank) {
        return bankRepository.saveAndFlush(bank);
    }

    @Override
    public List<Bank> getAllBank() {
        return bankRepository.findAll();
    }
}
