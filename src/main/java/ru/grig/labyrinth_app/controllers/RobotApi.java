package ru.grig.labyrinth_app.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.grig.labyrinth_app.common.StatusEnum;
import ru.grig.labyrinth_app.common.StatusMessage;
import ru.grig.labyrinth_app.domain.entities.Robot;
import ru.grig.labyrinth_app.services.RobotService;

@RestController
@RequestMapping("/robot")
public class RobotApi {

    private final RobotService robotService;

    @Autowired
    public RobotApi(RobotService robotService) {
        this.robotService = robotService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Robot robot) {
        try {
            return ResponseEntity.ok(robotService.create(robot));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(new StatusMessage(StatusEnum.ERROR, ex.getMessage()));
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        try {
            return ResponseEntity.ok(robotService.findAll());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(new StatusMessage(StatusEnum.ERROR, ex.getMessage()));
        }
    }

    @GetMapping("/findByName")
    public ResponseEntity<?> getByName(@RequestAttribute(name = "name") String name) {
        try {
            return ResponseEntity.ok(robotService.findByName(name));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new StatusMessage(StatusEnum.ERROR, e.getMessage()));
        }
    }

    @PostMapping("/update")
    public  ResponseEntity<?> update(@RequestBody Robot robot) {
        try {
            return ResponseEntity.ok(robotService.update(robot));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(new StatusMessage(StatusEnum.ERROR, ex.getMessage()));
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody Robot robot) {
        try {
            robotService.delete(robot);
            return ResponseEntity.ok(new StatusMessage(StatusEnum.SUCCESS, "Robot removed"));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(
                    new StatusMessage(StatusEnum.ERROR, "Create robot error: " + ex.getMessage()));
        }
    }
}
