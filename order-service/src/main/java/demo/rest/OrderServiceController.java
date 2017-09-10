package demo.rest;

import demo.model.Order;
import demo.model.OrderAction;
import demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderServiceController {
    private OrderService orderService;

    @Autowired
    public OrderServiceController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public List<Order> view(){
        return orderService.findAll();
    }

    @RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
    public Order findOrderById(@PathVariable("id") String id) {
        return orderService.findByOrderId(id);
    }

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Order placeOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @RequestMapping(value = "/order/{id}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void updateOrderStatus(@PathVariable("id") String id, @RequestBody OrderAction orderAction) {
        orderService.updateOrderStatus(id, orderAction);
    }

    @RequestMapping(value = "/order", method = RequestMethod.DELETE)
    public void deleteAll() {
        orderService.deleteAll();
    }
}
