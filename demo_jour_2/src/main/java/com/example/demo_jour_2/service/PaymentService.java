package com.example.demo_jour_2.service;

import com.example.demo_jour_2.entity.Payment;
import com.example.demo_jour_2.repository.PaymentRepository;
import org.springframework.transaction.annotation.Transactional;

public class PaymentService {


    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Transactional(readOnly = true)
    public Payment read(String cardNumber) {
            return paymentRepository.findByCreditCardNumber(cardNumber);
            //Librairie qui fait de l'ecriture
    }
}
