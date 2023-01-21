package com.example.Bank.mapper;

import com.example.Bank.dto.CreditDto;
import com.example.Bank.model.Credit;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CreditMapper {

    CreditMapper INSTANCE = Mappers.getMapper(CreditMapper.class);

    CreditDto creditToCreditDto(Credit credit);

    Credit creditDtoToCredit(CreditDto creditDto);
}
