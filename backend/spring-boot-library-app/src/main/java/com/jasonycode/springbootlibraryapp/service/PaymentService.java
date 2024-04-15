package com.jasonycode.springbootlibraryapp.service;

import com.jasonycode.springbootlibraryapp.dao.PaymentRepository;
import com.stripe.Stripe;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Value;

@Service
@Transactional
public class PaymentService {

    private PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository, @Value("${stripe.key.secret}") String secretKey) {
        this.paymentRepository = paymentRepository;
        Stripe.apiKey = secretKey;
    }
}
