package com.javaexpress.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaexpress.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer>{
}
