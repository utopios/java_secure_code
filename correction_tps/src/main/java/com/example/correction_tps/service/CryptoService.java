package com.example.correction_tps.service;

import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;
import java.util.Base64;

@Service
public class CryptoService {
    private static final String AES_ALGORITHM = "AES";
    private static final int AES_KEY_SIZE = 256;

    private static final String RSA_ALGORITHM = "RSA";
    private static final int RSA_KEY_SIZE = 2048;

    private final LoggingService loggingService;

    public CryptoService(LoggingService loggingService) {
        this.loggingService = loggingService;
    }

    // Génère une clé AES aléatoire de 256 bits
    public SecretKey generateAESKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance(AES_ALGORITHM);
        keyGen.init(AES_KEY_SIZE);
        loggingService.logAudit("Génération de clé ");
        return keyGen.generateKey();
    }

    // Chiffre les données avec AES
    public String encryptDataWithAES(String data, SecretKey aesKey) throws Exception {
        Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, aesKey);
        byte[] encryptedData = cipher.doFinal(data.getBytes());
        loggingService.logAudit("encrypt data ");
        return Base64.getEncoder().encodeToString(encryptedData);
    }

    // Déchiffre les données avec AES
    public String decryptDataWithAES(String encryptedData, SecretKey aesKey) throws Exception {
        Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, aesKey);
        byte[] decodedData = Base64.getDecoder().decode(encryptedData);
        return new String(cipher.doFinal(decodedData));
    }

    // Génère une paire de clés RSA de 2048 bits
    public KeyPair generateRSAKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(RSA_ALGORITHM);
        keyPairGenerator.initialize(RSA_KEY_SIZE);
        return keyPairGenerator.generateKeyPair();
    }

    // Chiffre la clé AES avec RSA
    public String encryptAESKeyWithRSA(SecretKey aesKey, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptedKey = cipher.doFinal(aesKey.getEncoded());
        return Base64.getEncoder().encodeToString(encryptedKey);
    }

    // Déchiffre la clé AES avec RSA
    public SecretKey decryptAESKeyWithRSA(String encryptedAESKey, PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decodedKey = Base64.getDecoder().decode(encryptedAESKey);
        byte[] decryptedKey = cipher.doFinal(decodedKey);
        return new SecretKeySpec(decryptedKey, AES_ALGORITHM);
    }
}
