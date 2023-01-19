package com.example.Bank.mapper;

import com.example.Bank.dto.PaymentScheduleDto;
import com.example.Bank.model.PaymentSchedule;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PaymentScheduleMapper {

    PaymentScheduleMapper INSTANCE = Mappers.getMapper(PaymentScheduleMapper.class);

    List<PaymentScheduleDto> paymentSchedulesToPaymentScheduleDtoList(List<PaymentSchedule> paymentSchedules);

    PaymentSchedule paymentScheduleDtoToPaymentSchedule(PaymentScheduleDto paymentScheduleDto);
}
