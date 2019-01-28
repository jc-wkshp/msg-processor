package com.wkshp.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
class ApplicationController {
	
	@Autowired
    private MessageProducer producer;

    @Autowired
    private PaymentRepository paymentRepository;
	
    @RequestMapping(value="/")
	String showStatus(){
		return "AMQ Demo Application - running.";
    }
    
    @GetMapping(value="/payments")
	List<Payment> getPayments(){
        return paymentRepository.findAll();
    }

    @PostMapping("/payment")
	String postPayment(@RequestBody String payment){
		producer.send(payment.toString());
		return "Payment -["+payment+"] Successfully Sent";
    }
    
}