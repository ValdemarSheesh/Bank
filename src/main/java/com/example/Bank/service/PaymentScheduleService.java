package com.example.Bank.service;

import com.example.Bank.model.PaymentSchedule;

public interface PaymentScheduleService {
    PaymentSchedule addPaymentSchedule(PaymentSchedule paymentSchedule);
    void deletePaymentSchedule(long id);
    PaymentSchedule getPaymentScheduleById(long id);
    PaymentSchedule editPaymentSchedule(PaymentSchedule paymentSchedule);
}
