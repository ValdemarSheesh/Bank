package com.example.Bank.service.impl;

import com.example.Bank.exceptions.NotFoundException;
import com.example.Bank.model.Credit;
import com.example.Bank.repo.CreditRepository;
import com.example.Bank.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditServiceImpl implements CreditService {

    @Autowired
    private CreditRepository creditRepository;

    @Override
    public Credit addCredit(Credit credit) {
        return creditRepository.saveAndFlush(credit);
    }

    @Override
    public void deleteCredit(long id) {
        creditRepository.delete(getCreditById(id));
    }

    @Override
    public Credit getCreditById(long id) {
        return creditRepository.findById(id).orElseThrow(() -> new NotFoundException("Credit with id " + id + " not found"));
    }

    @Override
    public Credit editCredit(Credit credit) {
        getCreditById(credit.getId());
        return creditRepository.saveAndFlush(credit);
    }
}
