package ru.grig.labyrinth_app.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.grig.labyrinth_app.domain.entities.Robot;
import ru.grig.labyrinth_app.repo.RobotRepository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class RobotService {

    private final RobotRepository robotRepository;

    @Autowired
    public RobotService(RobotRepository robotRepository) {
        this.robotRepository = robotRepository;
    }


    public Robot create(Robot robot) {
        return robotRepository.save(robot);
    }

    public List<Robot> findAll() {
        return robotRepository.findAll();
    }

    public Robot findByName(String name) throws Exception {
        Optional<Robot> robotOptional = robotRepository.findByName(name);
        return robotOptional.orElseThrow(() -> new Exception("Robot don't exist"));
    }

    public void delete(Robot robot) {
        robotRepository.delete(robot);
    }

    public Robot update(Robot robot) throws Exception {
        Optional<Robot> updatedRobotOptional = robotRepository.findById(robot.getId());
        ObjectMapper objectMapper = new ObjectMapper();
        if (updatedRobotOptional.isPresent()) {
            Robot updatedRobot = objectMapper.readValue(objectMapper.writeValueAsString(robot), Robot.class);
            return robotRepository.save(updatedRobot);
        }
        throw new Exception("Robot not exist");
    }
}
