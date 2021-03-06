package demo.service.impl;

import demo.model.Order;
import demo.model.OrderAction;
import demo.model.OrderRepository;
import demo.model.OrderStatus;
import demo.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService{

    private OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }
    @Override
    public Order findByOrderId(String id) {
        return orderRepository.findOne(id);
    }

    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void cancelOrder(String id) {
        orderRepository.deleteById(id);
    }

    @Override
    public void updateOrderStatus(String id, OrderAction action) {
        orderRepository.updateOrderStatus(id, action);
    }

    @Override
    public void deleteAll() {
        orderRepository.deleteAll();
    }
    @Override
    public List<Order> findAll(){
        return orderRepository.findAll();
    }

}
