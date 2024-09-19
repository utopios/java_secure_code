package com.example.demo_jour_2.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class DataRequest {

    @NotBlank(message = "Le nom ne doit pas être vide")
    private String name;

    @Pattern(regexp = "^(0[1-9]|1[0-2])/([0-9]{2})$", message = "Date d'expiration invalide, doit être au format MM/YY")
    private String expirationDate;

    @DecimalMin( value = "0.0", message = "le montant doit être supérieur à 0")
    private Double amount;

    //Exemple pour empêcher des injections xss
    @Pattern(regexp = "^[a-zA-Z0-9_\\-\\s]+$", message = "Caractères non autorisés dans le nom d'utilisateur")
    private String comment;
}
