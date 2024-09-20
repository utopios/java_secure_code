package com.example.demo_jour_3.service;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
public class MemoryLeakExample {
    private List<String> list = new ArrayList<>();

    public void addData() {
        // Ajoute continuellement des données sans libérer la mémoire
        while (true) {
            list.add("Consommation de mémoire");
        }
    }

    public static void main(String[] args) {
        MemoryLeakExample example = new MemoryLeakExample();
        example.addData(); // Provoquera un OutOfMemoryError
        example = null;

        System.gc();
    }
}