package com.example.authentication.service;


import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

@Service
public class MultiFactorAuthService {

    private static final int TOKEN_VALIDITY_DURATION = 300000; // 5 minutes
    private Map<String, String> userTokens = new HashMap<>();
    private Map<String, Long> tokenTimestamps = new HashMap<>();

    // Générer un token temporaire (OTP) pour un utilisateur
    public String generateToken(String username) {
        SecureRandom random = new SecureRandom();
        int token = random.nextInt(1000000); // Générer un OTP de 6 chiffres
        String tokenStr = String.format("%06d", token); // S'assurer qu'il y a 6 chiffres

        // Stocker le token avec un timestamp
        userTokens.put(username, tokenStr);
        tokenTimestamps.put(username, System.currentTimeMillis());

        // Simuler l'envoi du token à l'utilisateur (par exemple via SMS ou application mobile)
        System.out.println("Token envoyé à l'utilisateur : " + tokenStr);

        return tokenStr;
    }

    // Valider le token envoyé à l'utilisateur
    public boolean validateToken(String username, String providedToken) {
        if (userTokens.containsKey(username)) {
            // Vérifier si le token est encore valide (moins de 5 minutes)
            long currentTime = System.currentTimeMillis();
            if ((currentTime - tokenTimestamps.get(username)) > TOKEN_VALIDITY_DURATION) {
                System.out.println("Token expiré.");
                return false;
            }

            // Vérifier si le token fourni correspond à celui généré
            return userTokens.get(username).equals(providedToken);
        }

        return false;
    }
}
