package demo.model;

import lombok.Data;

@Data
public class OrderAction {
    private String paymentId;
    private OrderStatus orderStatus;
    public OrderAction(String paymentId, OrderStatus orderStatus) {
        this.paymentId = paymentId;
        this.orderStatus = orderStatus;
    }
    public OrderAction(){}
}
