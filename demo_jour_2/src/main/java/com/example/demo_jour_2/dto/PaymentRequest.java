package com.example.demo_jour_2.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class PaymentRequest {

    @Pattern(regexp = "^[0-9]{16}$", message = "Le numéro carte doit comporter 16 chiffres")
    @NotBlank(message = "Le numéro de carte ne peut pas être vide")
    private String creditCardNumber;
    @NotBlank(message = "Le nom du titulaire ne peut pas être vide")
    private String cardHolderName;

    @Pattern(regexp = "^(0[1-9]|1[0-2])/([0-9]{2})$", message = "Date d'expiration invalide, doit être au format MM/YY")
    private String expirationDate;

    @Pattern(regexp = "^[0-9]{3,4}$", message = "Le CVV doit comporter 3 ou 4 chiffres")
    private String cvv;
    @NotNull(message = "Le montant ne peut pas être nul")
    @DecimalMin( value = "0.0", message = "le montant doit être supérieur à 0")
    private Double amount;
}

