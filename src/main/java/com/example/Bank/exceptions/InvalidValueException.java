package com.example.Bank.exceptions;

import org.springframework.validation.BindingResult;

public class InvalidValueException extends RuntimeException{
    private BindingResult bindingResult;
    public InvalidValueException(String message, BindingResult bindingResult) {
        super(message);
        this.bindingResult = bindingResult;
    }

    public BindingResult getBindingResult() {
        return bindingResult;
    }

    public void setBindingResult(BindingResult bindingResult) {
        this.bindingResult = bindingResult;
    }
}
