package com.example.Bank.service.impl;

import com.example.Bank.model.Credit;
import com.example.Bank.repo.CreditRepository;
import com.example.Bank.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;

public class CreditServiceImpl implements CreditService {

    @Autowired
    private CreditRepository creditRepository;

    @Override
    public Credit addCredit(Credit credit) {
        return creditRepository.saveAndFlush(credit);
    }

    @Override
    public void deleteCredit(long id) {
        creditRepository.deleteById(id);
    }

    @Override
    public Credit getCreditById(long id) {
        return creditRepository.getById(id);
    }

    @Override
    public Credit editCredit(Credit credit) {
        return creditRepository.saveAndFlush(credit);
    }
}
