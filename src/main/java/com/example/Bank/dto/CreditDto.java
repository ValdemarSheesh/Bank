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
public class CreditDto {

    private Long id;
    @Digits(integer = Integer.MAX_VALUE, fraction = 2)
    @Positive
    private BigDecimal creditLimit;
    @Positive
    @Digits(integer = 3, fraction = 2)
    private double interestRate;
}
