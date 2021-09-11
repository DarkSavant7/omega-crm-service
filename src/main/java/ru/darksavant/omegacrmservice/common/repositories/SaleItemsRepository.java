package ru.darksavant.omegacrmservice.common.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.darksavant.omegacrmservice.common.entities.SalesItems;


@Repository
public interface SaleItemsRepository extends JpaRepository<SalesItems,Long> {

}
