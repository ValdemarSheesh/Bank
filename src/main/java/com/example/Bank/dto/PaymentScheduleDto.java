package com.example.Bank.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
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
    @Pattern(regexp = "dd.MM.yyy")
    private LocalDate paymentDate;
    @Digits(integer = Integer.MAX_VALUE, fraction = 2)
    @Positive
    private BigDecimal paymentAmount;
    @Digits(integer = Integer.MAX_VALUE, fraction = 2)
    @Positive
    private BigDecimal repaymentAmountOfCreditBody;
    @Digits(integer = Integer.MAX_VALUE, fraction = 2)
    @Positive
    private double repaymentAmountPercent;
}
