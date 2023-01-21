package com.example.Bank.mapper.impl;

import com.example.Bank.dto.CreditOfferDtoToClient;
import com.example.Bank.dto.CreditOfferDtoToFill;
import com.example.Bank.mapper.CreditMapper;
import com.example.Bank.mapper.CreditOfferMapper;
import com.example.Bank.mapper.PaymentScheduleMapper;
import com.example.Bank.model.CreditOffer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CreditOfferMapperImpl implements CreditOfferMapper {

    @Override
    public CreditOfferDtoToClient creditOfferToCreditOfferDtoToClient(CreditOffer creditOffer) {
        CreditOfferDtoToClient creditOfferDtoToClient = INSTANCE.creditOfferToCreditOfferDtoToClient(creditOffer);
        creditOfferDtoToClient.setCreditDto(CreditMapper.INSTANCE.creditToCreditDto(creditOffer.getCredit()));
        creditOfferDtoToClient.setPaymentScheduleDtoList(PaymentScheduleMapper.INSTANCE.paymentSchedulesToPaymentScheduleDtoList(creditOffer.getPaymentSchedules()));
        return creditOfferDtoToClient;
    }

    @Override
    public CreditOffer creditOfferDtoToFillToCreditOffer(CreditOfferDtoToFill creditOfferDtoToFill) {
        CreditOffer creditOffer = INSTANCE.creditOfferDtoToFillToCreditOffer(creditOfferDtoToFill);
        creditOffer.setCredit(CreditMapper.INSTANCE.creditDtoToCredit(creditOfferDtoToFill.getCreditDto()));
        creditOffer.setPaymentSchedules(creditOfferDtoToFill);
        return creditOffer;
    }

    @Override
    public List<CreditOfferDtoToClient> creditOffersToCreditOffersDto(List<CreditOffer> creditOffers) {
        return creditOffers.stream().map(this::creditOfferToCreditOfferDtoToClient).collect(Collectors.toList());
    }

}
