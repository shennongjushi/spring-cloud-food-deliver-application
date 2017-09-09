package demo.service.impl;

import demo.model.*;
import demo.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Slf4j
@Service
public class PaymentServiceImpl implements PaymentService{

    private PaymentRepository paymentRepository;
    private OrderRepository orderRepository;
    private RestTemplate restTemplate;

    private Random random = new Random();

    @Autowired
    public PaymentServiceImpl(PaymentRepository paymentRepository, OrderRepository orderRepository, RestTemplate restTemplate) {
        this.paymentRepository = paymentRepository;
        this.orderRepository = orderRepository;
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
        Order order = orderRepository.getById(payment.getOrderId());
        String orderPage = "http://order-service";
        OrderAction orderAction = new OrderAction();
        if (validatePayment(payment, order)) {
            orderAction.setOrderStatus(OrderStatus.SUCCEED);
        } else {
            orderAction.setOrderStatus(OrderStatus.FAILED);
        }
        restTemplate.postForLocation(orderPage + "/order/" + order.getId(), orderAction);
    }

    private boolean validatePayment(Payment payment, Order order) {
        return random.nextBoolean();
    }
}
