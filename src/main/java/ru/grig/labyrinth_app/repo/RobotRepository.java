package ru.grig.labyrinth_app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.grig.labyrinth_app.domain.entities.Robot;

import java.util.Optional;

public interface RobotRepository extends JpaRepository<Robot, Long> {

    Optional<Robot> findByName(String name);

}
