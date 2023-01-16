package com.example.Bank.service.impl;

import com.example.Bank.exceptions.NotFoundException;
import com.example.Bank.model.Client;
import com.example.Bank.model.CreditOffer;
import com.example.Bank.repo.CreditOfferRepository;
import com.example.Bank.repo.CreditRepository;
import com.example.Bank.repo.PaymentScheduleRepository;
import com.example.Bank.service.CreditOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CreditOfferServiceImpl implements CreditOfferService {

    @Autowired
    private CreditOfferRepository creditOfferRepository;
    @Autowired
    private CreditRepository creditRepository;
    @Autowired
    private PaymentScheduleRepository paymentScheduleRepository;

    @Override
    public CreditOffer addCreditOffer(CreditOffer creditOffer) {
        creditRepository.saveAndFlush(creditOffer.getCredit());
        paymentScheduleRepository.saveAndFlush(creditOffer.getPaymentSchedule());
        return creditOfferRepository.saveAndFlush(creditOffer);
    }

    @Override
    public void deleteCreditOffer(long id) {
        creditOfferRepository.delete(getCreditOfferById(id));
    }

    @Override
    public CreditOffer getCreditOfferById(long id) {
        return creditOfferRepository.findById(id).orElseThrow(() -> new NotFoundException("Credit offer with id " + id + " not found"));
    }

    @Override
    public CreditOffer editCreditOffer(CreditOffer creditOffer) {
        getCreditOfferById(creditOffer.getId());
        creditRepository.saveAndFlush(creditOffer.getCredit());
        paymentScheduleRepository.saveAndFlush(creditOffer.getPaymentSchedule());
        return creditOfferRepository.saveAndFlush(creditOffer);
    }

    @Override
    public List<CreditOffer> getAllCreditOfferByClient(Client client) {
        return creditOfferRepository.findAll().stream().filter(i -> client.equals(i.getClient())).collect(Collectors.toList());
    }
}
