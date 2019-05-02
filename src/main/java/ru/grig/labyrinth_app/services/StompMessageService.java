package ru.grig.labyrinth_app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

@Service
@EnableScheduling
public class StompMessageService {

    private final SimpMessageSendingOperations messageTemplate;

    @Autowired
    public StompMessageService(SimpMessageSendingOperations messageTemplate) {
        this.messageTemplate = messageTemplate;
    }

    public void sendMessage(Object object) {
        messageTemplate.convertAndSend("/topic/robotState", ResponseEntity.ok(object));
    }
}
