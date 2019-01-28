package com.wkshp.demo;

import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
class MessageConsumer{
    
    @Autowired
	private PaymentRepository paymentRepository;

    @JmsListener(destination = "${jms.queue.destination}")
    public void processMsg(String message) {
        System.out.println("============= Received: " + message);
        Gson g = new Gson();
        Payment payment = g.fromJson(message, Payment.class);
        paymentRepository.save(payment);
    }
}