package demo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Document
public class Payment {
    @Id
    private String id;

    private String cardNumber;
    private String name;
    private String expireYear;
    private String expireMonth;
    private String securityCode;

    private String orderId;
    private PaymentStatus paymentStatus;
    private double price;

    @JsonCreator
    public Payment(@JsonProperty("cardNumber") String cardNumber,
                   @JsonProperty("name") String name,
                   @JsonProperty("expireYear") String expireYear,
                   @JsonProperty("expireMonth") String expireMonth,
                   @JsonProperty("securityCode") String securityCode,
                   @JsonProperty("orderId") String orderId,
                   @JsonProperty("price") Double price) {
        this.cardNumber = cardNumber;
        this.name = name;
        this.expireMonth = expireMonth;
        this.expireYear = expireYear;
        this.securityCode = securityCode;
        this.orderId = orderId;
        this.price = price;
        this.paymentStatus = PaymentStatus.PENDING;
    }

}
