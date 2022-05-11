package com.example.demo.ws;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class MessageEmitter {

    private final SimpMessageSendingOperations messagingTemplate;

    @Scheduled(fixedRate = 1000L, initialDelay = 1000L)
    public void emit() {
        messagingTemplate.convertAndSend("/topic/test-topic", UUID.randomUUID().toString());
    }

}
