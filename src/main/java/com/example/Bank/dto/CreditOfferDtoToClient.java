package com.example.Bank.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreditOfferDtoToClient {

    private Long id;
    private CreditDto creditDto;
    @Digits(integer = Integer.MAX_VALUE, fraction = 2)
    @Positive
    private double creditSum;
    private List<PaymentScheduleDto> paymentScheduleDtoList;
}
