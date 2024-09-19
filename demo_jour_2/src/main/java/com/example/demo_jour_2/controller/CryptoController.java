package com.example.demo_jour_2.controller;

import com.example.demo_jour_2.service.CryptoService;
import org.springframework.web.bind.annotation.*;

import javax.crypto.SecretKey;

@RestController
@RequestMapping("/api/crypto")
public class CryptoController {
    private final CryptoService cryptoService;

    private SecretKey secretKey;
    public CryptoController(CryptoService cryptoService) throws Exception {
        this.cryptoService = cryptoService;
        this.secretKey = cryptoService.generateKey();
    }

    // Endpoint pour chiffrer les données
    @PostMapping("/encrypt")
    public String encrypt(@RequestParam String data) throws Exception {
        return cryptoService.encrypt(data, secretKey);
    }

    // Endpoint pour déchiffrer les données
    @PostMapping("/decrypt")
    public String decrypt(@RequestParam String encryptedData) throws Exception {
        return cryptoService.decrypt(encryptedData, secretKey);
    }
}
