package ru.darksavant.omegacrmservice.common.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.darksavant.omegacrmservice.common.entities.CalculationItems;
import ru.darksavant.omegacrmservice.common.entities.Good;

import java.math.BigDecimal;
import java.util.Optional;


@Repository
public interface CalculationItemsRepository extends JpaRepository<CalculationItems,Long> {
    Optional<CalculationItems> findByGood(Good good);
    Optional<CalculationItems> findByQuantity(BigDecimal quantity);
}
