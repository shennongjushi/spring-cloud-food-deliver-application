package demo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MenuItem {
    private String id;
    private String name;
    private String description;
    private double price;

    public MenuItem(){}

    @JsonCreator
    public MenuItem(@JsonProperty("name") String name,
                    @JsonProperty("description") String description,
                    @JsonProperty("price") Double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
