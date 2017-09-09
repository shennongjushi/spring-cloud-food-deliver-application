package demo.model;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

public interface PaymentRepository extends MongoRepository<Payment, String> {
    Payment findByOrderId(@Param("orderId") String orderId);
    void deleteByOrderId(@Param("orderId") String orderId);
}
