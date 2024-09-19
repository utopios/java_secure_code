package com.example.correction_tps.service;


import com.example.correction_tps.entity.BankAccount;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class BankService {
    private final LoggingService loggingService;
    ConcurrentHashMap<String, BankAccount> bankDatabase = new ConcurrentHashMap<>();

    public BankService(LoggingService loggingService) {
        this.loggingService = loggingService;
    }

    public void addBankAccount(String number, BankAccount account) {
        bankDatabase.put(number, account);
    }

    public void deposit(BankAccount bankAccount, double amount) {
        bankAccount.getLock().lock();
        try {
            bankAccount.setBalance(bankAccount.getBalance() + amount);
            loggingService.logAudit("Depot sur compte "+ bankAccount.getAccountNumber());
        }finally {
            bankAccount.getLock().unlock();
        }
    }

    public void simulation() {
        BankAccount bankAccount1 = BankAccount.builder().accountNumber("111").balance(0).build();
        BankAccount bankAccount2 = BankAccount.builder().accountNumber("112").balance(0).build();
        bankDatabase.put("111", bankAccount1);
        bankDatabase.put("112", bankAccount2);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Runnable deposit = () -> {
            deposit(bankDatabase.get("111"),200);
            deposit(bankDatabase.get("112"),200);
        };
        Runnable withdraw = () -> {
            deposit(bankDatabase.get("111"),100);
            deposit(bankDatabase.get("112"),100);
        };

        for(int i=0; i < 3; i++) {
            executorService.submit(deposit);
            executorService.submit(withdraw);
        }
    }

    public void withdraw(BankAccount bankAccount, double amount) {
        bankAccount.getLock().lock();
        try {
            if(bankAccount.getBalance() >= amount) {
                bankAccount.setBalance(bankAccount.getBalance() + amount);
                loggingService.logAudit("retrait sur compte "+ bankAccount.getAccountNumber());
            }else {
                loggingService.logDebug("tentative de retrait infructueuse "+ bankAccount.getAccountNumber());
            }
        }finally {
            bankAccount.getLock().unlock();
        }
    }
}
