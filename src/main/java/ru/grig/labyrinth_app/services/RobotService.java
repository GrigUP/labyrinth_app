package ru.grig.labyrinth_app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.grig.labyrinth_app.domain.entities.Robot;
import ru.grig.labyrinth_app.repo.RobotRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RobotService {

    private final RobotRepository robotRepository;

    @Autowired
    public RobotService(RobotRepository robotRepository) {
        this.robotRepository = robotRepository;
    }


    public Robot createRobot(Robot robot) {
        return robotRepository.save(robot);
    }

    public List<Robot> findAll() {
        return robotRepository.findAll();
    }

    public Robot findByName(String name) throws Exception {
        Optional<Robot> robotOptional = robotRepository.findByName(name);
        return robotOptional.orElseThrow(() -> new Exception("Robot don't exist"));
    }

    public void deleteRobot(Robot robot) {
        robotRepository.delete(robot);
    }

    public Robot update(Robot robot) {
        return robotRepository.save(robot);
    }
}
