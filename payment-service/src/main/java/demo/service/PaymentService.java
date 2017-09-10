package demo.service;

import demo.model.Payment;

import java.util.List;

public interface PaymentService {
    Payment findByOrderId(String orderId);
    void deleteByOrderId(String orderId);
    void deleteAll();
    void handlePayment(Payment payment);
    List<Payment> findAll();
}
