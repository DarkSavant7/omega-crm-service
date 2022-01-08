package ru.darksavant.omegacrmservice.common.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.darksavant.omegacrmservice.common.entities.TaskStatus;

import java.util.Optional;


@Repository
public interface TaskStatusRepository extends JpaRepository<TaskStatus,Long> {
    Optional<TaskStatus> findByDescription(String description);

}
