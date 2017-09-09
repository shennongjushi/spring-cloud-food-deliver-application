package demo.rest;

import demo.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.http.HttpStatus;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.web.bind.annotation.*;

@EnableBinding(Source.class)
@RestController
public class PaymentUploadController {
    @Autowired
    private MessageChannel output;

    @RequestMapping(value = "/payment", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void paymentUpload(@RequestBody Payment payment) {
        this.output.send(MessageBuilder.withPayload(payment).build());
    }
}
