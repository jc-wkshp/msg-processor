package com.wkshp.demo;

import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
class MessageConsumer{

	@Autowired
	private MessageRepository messageRepository;

    @JmsListener(destination = "${jms.queue.destination}")
    public void processMsg(String message) {
        System.out.println("============= Received: " + message);
        Gson g = new Gson();
        Payment payment = g.fromJson(message, Payment.class);
        System.out.println("============= After Payment: " + payment);
        //messageRepository.save(new Message(message));
    }
}