package com.example.Bank.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClientDto {

    private String name;
    private String surname;
    private String patronymic;
    private Integer phoneNumber;
    private Integer passportNumber;
}
