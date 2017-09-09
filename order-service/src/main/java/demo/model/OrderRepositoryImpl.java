package demo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;


public class OrderRepositoryImpl implements OrderRepositoryCustom{

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public void updateOrderStatus(String id, OrderAction action) {
        System.out.println("hello");
        Order order = mongoTemplate.findById(id, Order.class);
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(order.getId()));
        Update update = new Update();
        update.set("paymentId", action.getPaymentId());
        update.set("orderStatus", action.getOrderStatus());

        mongoTemplate.updateFirst(query, update, Order.class);

        order = mongoTemplate.findById(id, Order.class);

    }
}
