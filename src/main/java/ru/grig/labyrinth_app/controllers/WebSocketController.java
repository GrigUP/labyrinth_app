package ru.grig.labyrinth_app.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import ru.grig.labyrinth_app.domain.RobotState;

@Controller
public class WebSocketController {

    private int value = 0;

    @MessageMapping("/state")
    @SendTo("/topic/robotState")
    public ResponseEntity<?> handler(RobotState robotState) {
        System.out.println(robotState);
        return ResponseEntity.ok(new RobotState(value++,value));
    }

    @SendTo("/topic/robotState")
    public void sendMessage(RobotState robotState) {

    }

}
