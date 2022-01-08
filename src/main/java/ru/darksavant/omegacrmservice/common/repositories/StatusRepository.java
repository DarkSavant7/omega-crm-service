package ru.darksavant.omegacrmservice.common.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.darksavant.omegacrmservice.common.entities.Status;

import java.util.Optional;


@Repository
public interface StatusRepository extends JpaRepository<Status,Long> {

    Optional<Status> findByTitle(String name);
}
