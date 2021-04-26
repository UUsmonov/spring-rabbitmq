package com.example.springrabbitmq.service;

import com.example.springrabbitmq.config.RabbitBinding;
import com.example.springrabbitmq.models.RabbitMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RabbitService {
    private final RabbitTemplate rabbitTemplate;

    public RabbitService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public ResponseEntity<?> publish(RabbitMessage rabbitMessage) {
        rabbitTemplate.convertAndSend(RabbitBinding.EXCHANGE, RabbitBinding.ROUTING_KEY, rabbitMessage);
        return ResponseEntity.ok("success");
    }

    @RabbitListener(queues = RabbitBinding.QUEUE)
    public void consumeMessage(RabbitMessage rabbitMessage) {
        System.out.println(rabbitMessage);
    }
}
