package com.example.Bank.service.impl;

import com.example.Bank.model.CreditOffer;
import com.example.Bank.repo.CreditOfferRepository;
import com.example.Bank.service.CreditOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditOfferServiceImpl implements CreditOfferService {

    @Autowired
    private CreditOfferRepository creditOfferRepository;

    @Override
    public CreditOffer addCreditOffer(CreditOffer creditOffer) {
        return creditOfferRepository.saveAndFlush(creditOffer);
    }

    @Override
    public void deleteCreditOffer(long id) {
        creditOfferRepository.deleteById(id);
    }

    @Override
    public CreditOffer getCreditOfferById(long id) {
        return creditOfferRepository.getById(id);
    }

    @Override
    public CreditOffer editCreditOffer(CreditOffer creditOffer) {
        return creditOfferRepository.saveAndFlush(creditOffer);
    }
}
