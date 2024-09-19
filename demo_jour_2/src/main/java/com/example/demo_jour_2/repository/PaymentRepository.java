package com.example.demo_jour_2.repository;

import com.example.demo_jour_2.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    @Query("SELECT p FROM Payment p WHERE p.creditCardNumber = :cardNumber")
    Payment findByCreditCardNumber(@Param("cardNumber") String cardNumber);
}

