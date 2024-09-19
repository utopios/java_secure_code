package com.example.correction_tps.entity;


import lombok.Builder;
import lombok.Data;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Data
@Builder
public class BankAccount {
    private double balance;
    private String accountNumber;
    private final Lock lock = new ReentrantLock();

}
