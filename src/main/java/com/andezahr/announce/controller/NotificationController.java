package com.andezahr.announce.controller;

import com.andezahr.announce.event.NotificationEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notify")
@RequiredArgsConstructor
public class NotificationController {
    private final KafkaTemplate<String, NotificationEvent> kafkaTemplate;

    @PostMapping
    public ResponseEntity<String> send(@RequestBody NotificationEvent event) {
        kafkaTemplate.send("notifications", event);
        return ResponseEntity.accepted().body("Event published");
    }
}
