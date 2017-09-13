package demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import demo.model.Payment;
import demo.model.PaymentRequest;
import demo.model.PaymentStatus;
import demo.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.handler.annotation.MessageMapping;

import java.io.IOException;

//@MessageEndpoint
@EnableBinding(Sink.class)
public class PaymentServiceSink {

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private PaymentService paymentService;

    @ServiceActivator(inputChannel = Sink.INPUT)
    public void handlePayment(String input) throws IOException{
        Payment payment = objectMapper.readValue(input, Payment.class);
        paymentService.handlePayment(payment);
    }
}
