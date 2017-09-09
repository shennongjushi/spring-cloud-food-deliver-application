package demo.service;

import demo.model.Order;
import demo.model.OrderAction;

import java.util.List;

public interface OrderService {
    Order findByOrderId(String id);
    Order createOrder(Order order);
    void cancelOrder(String id);
    void deleteAll();
    void updateOrderStatus(String id, OrderAction action);
    List<Order> findAll();
}
