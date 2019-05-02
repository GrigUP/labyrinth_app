package ru.grig.labyrinth_app.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.grig.labyrinth_app.common.StatusEnum;
import ru.grig.labyrinth_app.common.StatusMessage;
import ru.grig.labyrinth_app.domain.entities.Labyrinth;
import ru.grig.labyrinth_app.services.LabyrinthService;

@RestController
@RequestMapping("/labyrinth")
public class LabyrinthApi {

    private final LabyrinthService labyrinthService;

    @Autowired
    public LabyrinthApi(LabyrinthService labyrinthService) {
        this.labyrinthService = labyrinthService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Labyrinth labyrinth) {
        try {
            return ResponseEntity.ok(labyrinthService.createLabyrinth(labyrinth));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(new StatusMessage(StatusEnum.ERROR, ex.getMessage()));
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> getAll() {
        try {
            return ResponseEntity.ok(labyrinthService.findAll());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(new StatusMessage(StatusEnum.ERROR, ex.getMessage()));
        }
    }

    @GetMapping("/findByName")
    public ResponseEntity<?> getByName(@RequestParam(name = "name") String name) {
        try {
            return ResponseEntity.ok(labyrinthService.findByName(name));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(new StatusMessage(StatusEnum.ERROR, ex.getMessage()));
        }
    }

    @PostMapping("/update")
    public  ResponseEntity<?> update(@RequestBody Labyrinth labyrinth) {
        try {
            return ResponseEntity.ok(labyrinthService.update(labyrinth));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(new StatusMessage(StatusEnum.ERROR, ex.getMessage()));
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody Labyrinth labyrinth) {
        try {
            labyrinthService.delete(labyrinth);
            return ResponseEntity.ok(new StatusMessage(StatusEnum.SUCCESS, "Labyrinth removed"));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(
                    new StatusMessage(StatusEnum.ERROR, ex.getMessage())
            );
        }
    }
}
