package ru.darksavant.omegacrmservice.common.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.darksavant.omegacrmservice.common.entities.Sale;

public interface SalesRepository extends JpaRepository<Sale,Long> {
}
