package ru.darksavant.omegacrmservice.common.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.darksavant.omegacrmservice.common.entities.SaleStatus;
@Repository
public interface SaleStatusRepository extends JpaRepository<SaleStatus,Long> {
}
