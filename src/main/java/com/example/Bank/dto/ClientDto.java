package com.example.Bank.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClientDto {
    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @NotBlank
    private String patronymic;
    @Digits(integer = 12, fraction = 0)
    @Positive
    private Integer phoneNumber;
    @Digits(integer = 10, fraction = 0)
    @Positive
    private Integer passportNumber;
}
