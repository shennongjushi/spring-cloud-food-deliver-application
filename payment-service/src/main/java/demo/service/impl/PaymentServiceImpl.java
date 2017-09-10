package demo.service.impl;

import demo.model.*;
import demo.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;

@Slf4j
@Service
public class PaymentServiceImpl implements PaymentService{

    private PaymentRepository paymentRepository;
    private RestTemplate restTemplate;

    private Random random = new Random();

    @Autowired
    public PaymentServiceImpl(PaymentRepository paymentRepository, RestTemplate restTemplate) {
        this.paymentRepository = paymentRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public Payment findByOrderId(String orderId) {
        return paymentRepository.findByOrderId(orderId);
    }

    @Override
    public void deleteByOrderId(String orderId) {
        paymentRepository.deleteByOrderId(orderId);
    }

    @Override
    public void deleteAll() {
        paymentRepository.deleteAll();
    }

    @Override
    public void handlePayment(Payment payment) {
        paymentRepository.save(payment);
        //String orderPage = "http://order-service";
        String orderPage = "http://localhost:8004";
        OrderAction orderAction = new OrderAction(payment.getId(),OrderStatus.PENDING);
        if (validatePayment(payment)) {
            orderAction.setOrderStatus(OrderStatus.SUCCEED);
        } else {
            orderAction.setOrderStatus(OrderStatus.FAILED);
        }
        restTemplate.postForLocation(orderPage + "/order/" + payment.getOrderId(), orderAction);
    }

    @Override
    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }

    private boolean validatePayment(Payment payment) {
        return random.nextBoolean();
    }
}
