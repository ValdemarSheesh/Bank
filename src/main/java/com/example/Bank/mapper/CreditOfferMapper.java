package com.example.Bank.mapper;

import com.example.Bank.dto.CreditOfferDtoToClient;
import com.example.Bank.dto.CreditOfferDtoToFill;
import com.example.Bank.model.CreditOffer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CreditOfferMapper {

    CreditOfferMapper INSTANCE = Mappers.getMapper(CreditOfferMapper.class);

    CreditOfferDtoToClient creditOfferToCreditOfferDtoToClient(CreditOffer creditOffer);

    CreditOffer creditOfferDtoToFillToCreditOffer(CreditOfferDtoToFill creditOfferDtoToFill);

    List<CreditOfferDtoToClient> creditOffersToCreditOffersDto(List<CreditOffer> creditOffers);

}
