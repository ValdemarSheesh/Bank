package com.example.Bank.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    public Client(String name, String surname, String patronymic, String phoneNumber, String passportNumber) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.phoneNumber = phoneNumber;
        this.passportNumber = passportNumber;
    }

    private String name;
    private String surname;
    private String patronymic;
    private String phoneNumber;
    private String passportNumber;

    @Override
    public String toString() {
        return "Client{" + id + name+ surname + patronymic + phoneNumber + passportNumber + '}';
    }
}
