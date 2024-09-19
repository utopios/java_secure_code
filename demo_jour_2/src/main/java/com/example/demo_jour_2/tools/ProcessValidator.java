package com.example.demo_jour_2.tools;

import java.io.IOException;

public class ProcessValidator {
    //avec userInput => user; rm -rf /
    /*public void findFile(String userInput) throws IOException {
        String command = "ls /user/files/" + userInput;
        ProcessBuilder processBuilder = new ProcessBuilder("bash", "-c", command);
        processBuilder.start();
    }*/

    public void findFile(String userInput) throws IOException {
        // Validation stricte de l'entrée utilisateur
        if (userInput.matches("^[a-zA-Z0-9_\\-]+$")) {
            String command = "ls /user/files/" + userInput;
            ProcessBuilder processBuilder = new ProcessBuilder("bash", "-c", command);
            processBuilder.start();
        } else {
            throw new IllegalArgumentException("Nom de fichier invalide");
        }
    }
}
