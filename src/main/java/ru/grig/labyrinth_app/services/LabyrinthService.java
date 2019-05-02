package ru.grig.labyrinth_app.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.grig.labyrinth_app.domain.entities.Labyrinth;
import ru.grig.labyrinth_app.repo.LabyrinthRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LabyrinthService {

    private final LabyrinthRepository labyrinthRepository;

    @Autowired
    public LabyrinthService(LabyrinthRepository labyrinthRepository) {
        this.labyrinthRepository = labyrinthRepository;
    }

    public Labyrinth create(Labyrinth labyrinth) {
        return labyrinthRepository.save(labyrinth);
    }

    public List<Labyrinth> findAll() {
        return labyrinthRepository.findAll();
    }

    public Labyrinth findByName(String name) throws Exception {
        Optional<Labyrinth> labyrinthOptional = labyrinthRepository.findByName(name);
        return labyrinthOptional.orElseThrow(() -> new Exception("Labyrinth don't exist"));
    }

    public void delete(Labyrinth labyrinth) throws Exception {
        labyrinthRepository.delete(labyrinth);
    }

    public Labyrinth update(Labyrinth labyrinth) throws Exception {
        Optional<Labyrinth> labyrinthOptional = labyrinthRepository.findById(labyrinth.getId());
        if (labyrinthOptional.isPresent()) {
            Labyrinth updatedLabyrinth = labyrinthOptional.get();
            updatedLabyrinth.setName(labyrinth.getName());
            updatedLabyrinth.setX(labyrinth.getX());
            updatedLabyrinth.setY(labyrinth.getY());
            updatedLabyrinth.setRouteColor(labyrinth.getRouteColor());
            updatedLabyrinth.setWallColor(labyrinth.getWallColor());
            updatedLabyrinth.setMap(labyrinth.getMap());
            updatedLabyrinth.setRobot(labyrinth.getRobot());

            labyrinthRepository.save(updatedLabyrinth);
        }
        throw new Exception("Labyrinth not exist");
    }
}
