package com.example.demo_jour_2.service;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Service
public class SynchroneService {
    Set<String> sets = new HashSet<>();
    private final Lock lock = new ReentrantLock();

    public  void addData(String data) {
        lock.lock();
        sets.add(data);
        lock.unlock();
    }
}
