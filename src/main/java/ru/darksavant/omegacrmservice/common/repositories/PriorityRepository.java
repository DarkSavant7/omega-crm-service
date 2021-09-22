package ru.darksavant.omegacrmservice.common.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.darksavant.omegacrmservice.common.entities.Priority;

import java.util.Optional;


@Repository
public interface PriorityRepository extends JpaRepository<Priority,Long> {
    Optional<Priority> findByDescription(String name);

}
