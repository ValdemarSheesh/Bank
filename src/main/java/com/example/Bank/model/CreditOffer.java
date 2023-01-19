package com.example.Bank.model;

import com.example.Bank.dto.CreditOfferDtoToFill;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.decimal4j.util.DoubleRounder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class CreditOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @OneToOne
    @JoinColumn(name = "credit_id")
    private Credit credit;
    private double creditSum;
    @OneToMany(cascade = CascadeType.ALL)
    private List<PaymentSchedule> paymentSchedules;

    public void setPaymentSchedules(CreditOfferDtoToFill creditOfferDtoToFill) {
        List<PaymentSchedule> paymentSchedules = new ArrayList<>();
        DoubleRounder rounder = new DoubleRounder(2);
        double interestRate = creditOfferDtoToFill.getCreditDto().getInterestRate() / 100;
        double creditSum = creditOfferDtoToFill.getCreditSum();
        int numOfMonths = creditOfferDtoToFill.getNumOfMonths();
        LocalDate paymentDate = LocalDate.now();

        double monthlyPercentRate = interestRate / 12;
        double annuityRatio = (monthlyPercentRate * Math.pow(1 + monthlyPercentRate, numOfMonths))
                / (Math.pow(1 + monthlyPercentRate, numOfMonths) - 1);
        double paymentAmount = rounder.round(creditSum * annuityRatio);

        for (int i = 0; i < numOfMonths; i++) {
            long numDaysInMonth = DAYS.between(paymentDate, paymentDate.plusMonths(1));
            double repaymentAmountPercent = rounder.round(creditSum * interestRate * numDaysInMonth / 365);
            double repaymentAmountOfCreditBody = rounder.round(paymentAmount - repaymentAmountPercent);
            PaymentSchedule paymentSchedule = new PaymentSchedule();
            paymentSchedule.setPaymentDate(paymentDate);
            paymentSchedule.setPaymentAmount(paymentAmount);
            paymentSchedule.setRepaymentAmountOfCreditBody(repaymentAmountOfCreditBody);
            paymentSchedule.setRepaymentAmountPercent(repaymentAmountPercent);
            paymentSchedules.add(paymentSchedule);
            creditSum -= paymentAmount;
            paymentDate = paymentDate.plusMonths(1);
        }
        this.paymentSchedules = paymentSchedules;
    }
}
