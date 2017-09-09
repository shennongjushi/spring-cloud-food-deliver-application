package demo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Document
public class RestaurantInfo {
    @Id
    private String restaurantId;
    @Indexed
    private String name;
    private String description;
    private String address;
    private List<MenuItem> menuItems = new ArrayList<>();

    public RestaurantInfo(){}

    @JsonCreator
    public RestaurantInfo(@JsonProperty("name") String name,
                          @JsonProperty("description") String description,
                          @JsonProperty("address") String address,
                          @JsonProperty("menuItems") List<MenuItem> menuItems) {
        this.name = name;
        this.description = description;
        this.address = address;
        this.menuItems = menuItems;
    }

    public void addMenuItem(MenuItem menuItem) {
        this.menuItems.add(menuItem);
    }
}
