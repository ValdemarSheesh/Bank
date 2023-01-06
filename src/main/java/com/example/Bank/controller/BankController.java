package com.example.Bank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("message")
public class BankController {
    private final String message = "Hi, my %s!";

    @GetMapping
    public String greeting() {
        return message;
    }

    @GetMapping("{name}")
    public String greetingWithName(@PathVariable String name) {
        return String.format(message, name);
    }
}
