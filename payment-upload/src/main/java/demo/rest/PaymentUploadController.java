package demo.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import demo.model.Payment;
import demo.model.PaymentStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.http.HttpStatus;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@EnableBinding(Source.class)
@RestController
public class PaymentUploadController {
    @Autowired
    private MessageChannel output;

    @RequestMapping(value = "/api/payments", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void payments(@RequestBody Payment payment) throws Exception{
        payment.setPaymentStatus(PaymentStatus.PENDING);
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writeValueAsString(payment);
        this.output.send(MessageBuilder.withPayload(jsonInString).build());
    }
}
