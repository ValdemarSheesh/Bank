package com.example.Bank.service;

import com.example.Bank.model.CreditOffer;

public interface CreditOfferService {
    CreditOffer addCreditOffer(CreditOffer creditOffer);
    void deleteCreditOffer(long id);
    CreditOffer getCreditOfferById(long id);
    CreditOffer editCreditOffer(CreditOffer creditOffer);
}
