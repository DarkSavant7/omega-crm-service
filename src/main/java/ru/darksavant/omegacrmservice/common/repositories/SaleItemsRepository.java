package ru.darksavant.omegacrmservice.common.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.darksavant.omegacrmservice.common.entities.Good;
import ru.darksavant.omegacrmservice.common.entities.Sale;
import ru.darksavant.omegacrmservice.common.entities.SalesItems;

import java.util.Optional;


@Repository
public interface SaleItemsRepository extends JpaRepository<SalesItems, Long> {
    Optional<SalesItems> findBySale(Sale sale);
    Optional<SalesItems> findByGood(Good good);

}
