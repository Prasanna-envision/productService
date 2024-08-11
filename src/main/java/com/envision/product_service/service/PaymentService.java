package com.envision.product_service.service;

import com.envision.product_service.entity.Payment;
import com.envision.product_service.repositry.PaymentRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepositry paymentRepositry;
    public Payment doPayment(Payment payment){
        payment.setPaymentStatus(paymentProcessing());
        payment.setTransactionId(UUID.randomUUID().toString());
        return paymentRepositry.save(payment);
    }
    public String paymentProcessing(){
        //we need implement third party payment processing gateway(Paypal,Paytm...)
        return new Random().nextBoolean()?"success":"false";
    }
    public Payment findPaymentHistoryByOrderId(int orderId){
        return paymentRepositry.findByOrderId(orderId);
    }
}
