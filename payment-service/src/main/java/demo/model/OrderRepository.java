package demo.model;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {
    void deleteById(String id);
    Order getById(String id);
}