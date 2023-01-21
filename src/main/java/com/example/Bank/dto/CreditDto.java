package com.example.Bank.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreditDto {

    private Long id;
    @Digits(integer = Integer.MAX_VALUE, fraction = 2)
    @Positive
    @Min(10000)
    @Max(100000000)
    private double creditLimit;
    @Positive
    @Digits(integer = 2, fraction = 2)
    @Min(1)
    private double interestRate;
}
