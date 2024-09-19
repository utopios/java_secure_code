package com.example.correction_tps.service;

import com.example.correction_tps.dto.PaymentRequest;
import com.example.correction_tps.entity.Payment;
import com.example.correction_tps.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;

@Service
public class PaymentService {

    private final CryptoService cryptoService;
    private final SecretKey secretKey;
    private final KeyPair keyPair;

    private LoggingService loggingService;

    private final PaymentRepository paymentRepository;
    public PaymentService(CryptoService cryptoService, PaymentRepository paymentRepository) {
        this.cryptoService = cryptoService;
        this.paymentRepository = paymentRepository;
        try {
            this.secretKey = cryptoService.generateAESKey();
            this.keyPair = cryptoService.generateRSAKeyPair();
        } catch (Exception e) {
            loggingService.logError("Payment Service,...." + e.getMessage());
            throw new RuntimeException("Problème de génération des clés");
        }

    }

    public void saveCard(PaymentRequest paymentRequest) {
        Payment payment = null;
        try {
            payment = Payment.builder()
                    .cardHolderName(cryptoService.encryptDataWithAES(paymentRequest.getCardHolderName(), secretKey))
                    .creditCardNumber(cryptoService.encryptDataWithAES(paymentRequest.getCreditCardNumber(), secretKey))
                    .cvv(paymentRequest.getCvv())
                    .amount(paymentRequest.getAmount())
                    .expirationDate(paymentRequest.getExpirationDate())
                    .build();
            paymentRepository.save(payment);
        } catch (Exception e) {
            loggingService.logError("Payment Service, save card...." + e.getMessage());
            throw new RuntimeException("Problème de sauvegarde de la clé");
        }


    }

}
