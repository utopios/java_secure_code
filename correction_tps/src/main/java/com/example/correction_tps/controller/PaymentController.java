package com.example.correction_tps.controller;



import com.example.correction_tps.dto.PaymentRequest;
import com.example.correction_tps.service.LoggingService;
import com.example.correction_tps.service.PaymentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("/payment")
public class PaymentController {

    private final PaymentService paymentService;

    private final LoggingService loggingService;
    public PaymentController(PaymentService paymentService, LoggingService loggingService) {
        this.paymentService = paymentService;
        this.loggingService = loggingService;
    }

    @PostMapping("")
    public ResponseEntity<String> post(@Valid @RequestBody PaymentRequest paymentRequest) {
        try {
            paymentService.saveCard(paymentRequest);
            return ResponseEntity.ok("OK");
        }catch (Exception ex) {
            return ResponseEntity.internalServerError().body("Erreur création carte");
        }

    }


}
