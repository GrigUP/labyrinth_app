package ru.grig.labyrinth_app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.grig.labyrinth_app.domain.entities.Labyrinth;
import java.util.Optional;

public interface LabyrinthRepository extends JpaRepository<Labyrinth, Long> {

    Optional<Labyrinth> findByName(String name);

}
