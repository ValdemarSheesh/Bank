package com.example.Bank.service;

import com.example.Bank.model.Credit;

public interface CreditService {
    Credit addCredit(Credit credit);
    void deleteCredit(long id);
    Credit getCreditById(long id);
    Credit editCredit(Credit credit);
}
