package demo.model;

public interface OrderRepositoryCustom {
    void updateOrderStatus(String id, OrderAction action);
}
