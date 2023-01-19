package com.example.Bank.dto;

import jakarta.validation.Valid;
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
public class CreditOfferDtoToFill {
    @Valid
    private CreditDto creditDto;
    @Digits(integer = Integer.MAX_VALUE, fraction = 2)
    @Positive
    @Min(10000)
    @Max(300000000)
    private double creditSum;
    @Digits(integer = 3, fraction = 0)
    @Positive
    @Min(1)
    @Max(360)
    private int numOfMonths;
}
