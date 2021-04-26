package com.example.springrabbitmq.controller;

import com.example.springrabbitmq.models.RabbitMessage;
import com.example.springrabbitmq.service.RabbitService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RabbitController {
    private final RabbitService rabbitService;

    public RabbitController(RabbitService rabbitService) {
        this.rabbitService = rabbitService;
    }

    @PostMapping("/publish")
    public ResponseEntity<?> publish(@RequestBody RabbitMessage rabbitMessage) {
        return rabbitService.publish(rabbitMessage);
    }
}
