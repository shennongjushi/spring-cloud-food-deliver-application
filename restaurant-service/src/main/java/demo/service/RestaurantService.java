package demo.service;

import demo.model.MenuItem;
import demo.model.RestaurantInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RestaurantService {
    List<RestaurantInfo> save(List<RestaurantInfo> restaurants);
    List<RestaurantInfo> findByName(String name);
    List<RestaurantInfo> getAllRestaurants();
    List<MenuItem> getMenuItems(String restaurantId);
    void deleteAll();
}
