package com.example.Bank.mapper.impl;

import com.example.Bank.dto.CreditOfferDto;
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
    public CreditOfferDto creditOfferToCreditOfferDto(CreditOffer creditOffer) {
        CreditOfferDto creditOfferDto = INSTANCE.creditOfferToCreditOfferDto(creditOffer);
        creditOfferDto.setCreditDto(CreditMapper.INSTANCE.creditToCreditDto(creditOffer.getCredit()));
        creditOfferDto.setPaymentScheduleDto(PaymentScheduleMapper.INSTANCE.paymentScheduleToPaymentScheduleDto(creditOffer.getPaymentSchedule()));
        return creditOfferDto;
    }

    @Override
    public CreditOffer creditOfferDtoToCreditOffer(CreditOfferDto creditOfferDto) {
        CreditOffer creditOffer = INSTANCE.creditOfferDtoToCreditOffer(creditOfferDto);
        creditOffer.setCredit(CreditMapper.INSTANCE.creditDtoToCredit(creditOfferDto.getCreditDto()));
        creditOffer.setPaymentSchedule(PaymentScheduleMapper.INSTANCE.paymentScheduleDtoToPaymentSchedule(creditOfferDto.getPaymentScheduleDto()));
        return creditOffer;
    }

    @Override
    public List<CreditOfferDto> creditOffersToCreditOffersDto(List<CreditOffer> creditOffers) {
        return creditOffers.stream().map(this::creditOfferToCreditOfferDto).collect(Collectors.toList());
    }

}
