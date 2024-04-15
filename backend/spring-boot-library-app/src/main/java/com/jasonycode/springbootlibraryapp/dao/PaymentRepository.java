package com.jasonycode.springbootlibraryapp.dao;

import com.jasonycode.springbootlibraryapp.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    Payment findByUserEmail(String userEmail);
}
