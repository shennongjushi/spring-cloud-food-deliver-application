package demo.model;

import lombok.Data;

@Data
public class OrderAction {
    private long paymentId;
    private OrderStatus orderStatus;
    public OrderAction(long paymentId, OrderStatus orderStatus) {
        this.paymentId = paymentId;
        this.orderStatus = orderStatus;
    }
    public OrderAction(){}
}
