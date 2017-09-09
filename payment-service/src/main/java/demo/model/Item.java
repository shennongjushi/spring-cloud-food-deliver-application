package demo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Item {
    private String id;
    private String name;
    private int quantity;
    private double price;
}
