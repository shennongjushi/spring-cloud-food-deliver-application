package demo.rest;

import demo.model.Payment;
import demo.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
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

    @RequestMapping(value = "/payment", method = RequestMethod.GET)
    public List<Payment> findAll(){
        return paymentService.findAll();
    }
}
