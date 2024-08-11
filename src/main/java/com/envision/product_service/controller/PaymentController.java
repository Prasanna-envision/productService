package com.envision.product_service.controller;

import com.envision.product_service.entity.Payment;
import com.envision.product_service.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
     @PostMapping("/doPayment")
    public Payment doPayment(@RequestBody Payment payment){
        return paymentService.doPayment(payment);
    }
  @GetMapping("/{orderId}")
  public Payment findPaymentHistoryByOrderId(@PathVariable int orderId){
         return paymentService.findPaymentHistoryByOrderId(orderId);
    }


}
