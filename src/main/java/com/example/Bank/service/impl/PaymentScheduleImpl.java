package com.example.Bank.service.impl;

import com.example.Bank.exceptions.NotFoundException;
import com.example.Bank.model.PaymentSchedule;
import com.example.Bank.repo.PaymentScheduleRepository;
import com.example.Bank.service.PaymentScheduleService;
import org.springframework.beans.factory.annotation.Autowired;

public class PaymentScheduleImpl implements PaymentScheduleService {

    @Autowired
    private PaymentScheduleRepository paymentScheduleRepository;

    @Override
    public PaymentSchedule addPaymentSchedule(PaymentSchedule paymentSchedule) {
        return paymentScheduleRepository.saveAndFlush(paymentSchedule);
    }

    @Override
    public void deletePaymentSchedule(long id) {
        paymentScheduleRepository.delete(getPaymentScheduleById(id));
    }

    @Override
    public PaymentSchedule getPaymentScheduleById(long id) {
        return paymentScheduleRepository.findById(id).orElseThrow(() -> new NotFoundException("Client with id " + id + " not found"));
    }

    @Override
    public PaymentSchedule editPaymentSchedule(PaymentSchedule paymentSchedule) {
        getPaymentScheduleById(paymentSchedule.getId());
        return paymentScheduleRepository.saveAndFlush(paymentSchedule);
    }
}
