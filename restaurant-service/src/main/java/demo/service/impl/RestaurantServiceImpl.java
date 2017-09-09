package demo.service.impl;

import demo.model.MenuItem;
import demo.model.RestaurantInfo;
import demo.model.RestaurantInfoRepository;
import demo.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService{

    private RestaurantInfoRepository restaurantInfoRepository;

    @Autowired
    public void RestaurantServiceImpl(RestaurantInfoRepository restaurantInfoRepository) {
        this.restaurantInfoRepository = restaurantInfoRepository;
    }

    @Override
    public List<RestaurantInfo> save(List<RestaurantInfo> restaurants) {
        return restaurantInfoRepository.save(restaurants);
    }

    @Override
    public List<RestaurantInfo> findByName(String name) {
        return restaurantInfoRepository.findByName(name);
    }

    @Override
    public List<RestaurantInfo> getAllRestaurants() {
        return restaurantInfoRepository.findAll();
    }

    @Override
    public List<MenuItem> getMenuItems(String restaurantId) {
        return restaurantInfoRepository.findOne(restaurantId).getMenuItems();
    }

    @Override
    public void deleteAll() {
        restaurantInfoRepository.deleteAll();
    }
}
