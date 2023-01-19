package com.example.Bank.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PaymentScheduleDto {

    private Long id;
    private LocalDate paymentDate;
    private BigDecimal paymentAmount;
    private BigDecimal repaymentAmountOfCreditBody;
    private double repaymentAmountPercent;
}
