package demo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderAction {
    private String paymentId;
    private OrderStatus orderStatus;
    @JsonCreator
    public OrderAction(@JsonProperty("paymentId") String paymentId,
                 @JsonProperty("orderStatus") OrderStatus orderStatus) {
        this.paymentId = paymentId;
        this.orderStatus = orderStatus;
    }
    public OrderAction(){}
}
