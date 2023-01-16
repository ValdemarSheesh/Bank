package com.example.Bank.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreditOfferDto {

    private CreditDto creditDto;
    @Digits(integer = Integer.MAX_VALUE, fraction = 2)
    @Positive
    private BigDecimal creditSum;
    private PaymentScheduleDto paymentScheduleDto;
}
