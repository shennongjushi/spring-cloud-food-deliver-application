package demo.service;

import demo.model.Payment;

public interface PaymentService {
    Payment findByOrderId(String orderId);
    void deleteByOrderId(String orderId);
    void deleteAll();
    void handlePayment(Payment payment);
}
