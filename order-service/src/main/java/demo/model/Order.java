package demo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.*;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Document(collection = "orders")
public class Order {
    @Id
    private String id;
    private String restaurantId;
    private Date orderTime;
    private List<Item> items = new ArrayList<>();
    private double totalPrice;
    @Indexed
    private long customerId;
    private String deliverAddress;
    private String note;
    private int deliveryTime;
    private OrderStatus orderStatus;

    private String paymentId;

    @JsonIgnore
    private Random random = new Random();
    public Order(){}

    @JsonCreator
    public Order(@JsonProperty("restaurantId") String restaurantId,
                 @JsonProperty("items") List<Item> items,
                 @JsonProperty("customerId") long customerId,
                 @JsonProperty("deliverAddress") String deliverAddress,
                 @JsonProperty("note") String note) {
        this.id = id;
        this.items = items;
        this.restaurantId = restaurantId;
        this.orderTime = new Date();
        this.totalPrice = calTotalPrice(items);
        this.customerId = customerId;
        this.deliverAddress = deliverAddress;
        this.note = note;
        this.deliveryTime = random.nextInt(56) + 5;
        this.orderStatus = OrderStatus.PENDING;
    }

    private double calTotalPrice(List<Item> items) {
        double price = 0.0;
        for (Item item : items) {
            price += item.getPrice() * item.getQuantity();
        }
        return price;
    }
}
