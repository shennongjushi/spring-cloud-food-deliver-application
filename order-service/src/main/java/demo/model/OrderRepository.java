package demo.model;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String>, OrderRepositoryCustom {
    void deleteById(String id);
    void deleteAll();
    Order findById(String id);
}
