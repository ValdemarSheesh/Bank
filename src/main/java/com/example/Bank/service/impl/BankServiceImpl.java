package com.example.Bank.service.impl;

import com.example.Bank.model.Bank;
import com.example.Bank.model.Client;
import com.example.Bank.model.Credit;
import com.example.Bank.repo.BankRepository;
import com.example.Bank.repo.ClientRepository;
import com.example.Bank.repo.CreditRepository;
import com.example.Bank.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankServiceImpl implements BankService {
    @Autowired
    private BankRepository bankRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private CreditRepository creditRepository;

    @Override
    public List<Credit> getAllCredits() {
        return creditRepository.findAll();
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }
}
