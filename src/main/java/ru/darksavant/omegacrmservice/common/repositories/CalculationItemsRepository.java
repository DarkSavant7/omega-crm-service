package ru.darksavant.omegacrmservice.common.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.darksavant.omegacrmservice.common.entities.CalculationItems;


@Repository
public interface CalculationItemsRepository extends JpaRepository<CalculationItems,Long> {

}
