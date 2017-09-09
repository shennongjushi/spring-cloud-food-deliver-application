package demo.model;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RestaurantInfoRepository extends MongoRepository<RestaurantInfo, String> {
    List<RestaurantInfo> findByName(@Param("name") String name);
}
