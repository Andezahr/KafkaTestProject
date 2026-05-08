package com.andezahr.announce.listener;

import com.andezahr.announce.event.NotificationEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class NotificationConsumer {
    @KafkaListener(topics = "notifications", groupId = "announce-group")
    public void handle(NotificationEvent event) {
        log.info("Sending {} to {}", event.message(), event.destination());
    }
}
