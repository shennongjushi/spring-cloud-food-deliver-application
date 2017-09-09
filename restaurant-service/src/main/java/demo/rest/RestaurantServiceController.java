package demo.rest;

import demo.model.MenuItem;
import demo.model.RestaurantInfo;
import demo.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestaurantServiceController {
    private RestaurantService restaurantService;

    @Autowired
    public RestaurantServiceController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @RequestMapping(value = "/restaurant", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    void saveRestaurant(@RequestBody List<RestaurantInfo> restaurants) {
        restaurantService.save(restaurants);
    }

    @RequestMapping(value = "/restaurant", method = RequestMethod.GET)
    List<RestaurantInfo> getAllRestaurant() {
        return restaurantService.getAllRestaurants();
    }

    @RequestMapping(value = "/restaurant/{name}", method = RequestMethod.GET)
    List<RestaurantInfo> getRestaurantByName(@PathVariable("name") String name) {
        return restaurantService.findByName(name);
    }

    @RequestMapping(value = "/restaurant/menu/{restaurantId}", method = RequestMethod.GET)
    List<MenuItem> getMenuByRestaurantId(@PathVariable("restaurantId") String restaurantId) {
        return restaurantService.getMenuItems(restaurantId);
    }

    @RequestMapping(value = "/restaurant", method = RequestMethod.DELETE)
    void purge() {
        restaurantService.deleteAll();
    }

}
