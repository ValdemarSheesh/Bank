package com.example.Bank.service;

import com.example.Bank.model.CreditOffer;

import java.util.List;

public interface CreditOfferService {
    CreditOffer addCreditOffer(CreditOffer creditOffer);
    void deleteCreditOffer(long id);
    CreditOffer getCreditOfferById(long id);
    CreditOffer editCreditOffer(CreditOffer creditOffer);
    List<CreditOffer> getAllCreditOffer();
}
