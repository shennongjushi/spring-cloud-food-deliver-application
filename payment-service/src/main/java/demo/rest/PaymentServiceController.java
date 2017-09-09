package demo.rest;

import demo.model.Payment;
import demo.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
public class PaymentServiceController {
    private PaymentService paymentService;

    @Autowired
    public PaymentServiceController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @RequestMapping(value = "/payment/{orderId}", method = RequestMethod.GET)
    public Payment findByOrderId(@PathVariable String orderId) {
        return paymentService.findByOrderId(orderId);
    }

    @RequestMapping(value = "/payment/purge", method = RequestMethod.DELETE)
    public void purge() {
        paymentService.deleteAll();
    }

    @RequestMapping(value = "/payment/cancel/{orderId}", method = RequestMethod.DELETE)
    public void cancelByOrderId(@PathVariable String orderId) {
        paymentService.deleteByOrderId(orderId);
    }
}
