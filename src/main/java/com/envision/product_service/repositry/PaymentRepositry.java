package com.envision.product_service.repositry;

import com.envision.product_service.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepositry extends JpaRepository<Payment,Integer> {
Payment findByOrderId(int orderId);
}
