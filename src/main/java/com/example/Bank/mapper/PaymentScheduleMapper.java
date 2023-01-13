package com.example.Bank.mapper;

import com.example.Bank.dto.PaymentScheduleDto;
import com.example.Bank.model.PaymentSchedule;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PaymentScheduleMapper {

    PaymentScheduleMapper INSTANCE = Mappers.getMapper(PaymentScheduleMapper.class);

    PaymentScheduleDto paymentScheduleToPaymentScheduleDto(PaymentSchedule paymentSchedule);

    PaymentSchedule paymentScheduleDtoToPaymentSchedule(PaymentScheduleDto paymentScheduleDto);
}
