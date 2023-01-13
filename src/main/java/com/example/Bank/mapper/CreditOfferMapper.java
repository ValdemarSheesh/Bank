package com.example.Bank.mapper;

import com.example.Bank.dto.CreditOfferDto;
import com.example.Bank.model.CreditOffer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CreditOfferMapper {

    CreditOfferMapper INSTANCE = Mappers.getMapper(CreditOfferMapper.class);

    CreditOfferDto creditOfferToCreditOfferDto(CreditOffer creditOffer);

    CreditOffer creditOfferDtoToCreditOffer(CreditOfferDto creditOfferDto);

    List<CreditOfferDto> creditOffersToCreditOffersDto(List<CreditOffer> creditOffers);

}
