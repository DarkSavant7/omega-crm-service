package ru.darksavant.omegacrmservice.common.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.darksavant.omegacrmservice.common.entities.Service;

import java.math.BigDecimal;
import java.util.Optional;


@Repository
public interface ServiceRepository extends JpaRepository<Service,Long> {

    Optional<Service> findByDescription(String name);

    Optional<Service> findByTitle(String name);

    Optional<Service> findByPrice(BigDecimal price);
}
