package ru.darksavant.omegacrmservice.common.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.darksavant.omegacrmservice.common.entities.WorkPlace;

import java.util.Optional;


@Repository
public interface WorkPlaceRepository extends JpaRepository<WorkPlace,Long> {

    Optional<WorkPlace> findByTitle(String name);
}
