package com.example.demo_jour_3.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CloseExample {
    public static void main(String[] args) {
        // Avant Java 7, fermeture manuelle
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("file.txt"));
            String line = reader.readLine();
            System.out.println(line);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close(); // Ferme le fichier pour libérer la ressource
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Depuis Java 7, utilisation de try-with-resources
        try (BufferedReader reader2 = new BufferedReader(new FileReader("file.txt"))) {
            String line = reader2.readLine();
            System.out.println(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}