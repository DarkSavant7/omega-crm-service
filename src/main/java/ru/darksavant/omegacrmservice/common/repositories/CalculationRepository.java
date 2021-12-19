package ru.darksavant.omegacrmservice.common.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.darksavant.omegacrmservice.common.entities.Calculation;
import ru.darksavant.omegacrmservice.common.entities.CalculationItems;
import ru.darksavant.omegacrmservice.common.entities.Good;

import java.util.List;
import java.util.Optional;


@Repository
public interface CalculationRepository extends JpaRepository<Calculation,Long> {
    Optional<Calculation> findByGood(Good good);

}
