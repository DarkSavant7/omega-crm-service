package ru.darksavant.omegacrmservice.common.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.darksavant.omegacrmservice.common.entities.SaleStatus;

public interface SaleStatusRepository extends JpaRepository<SaleStatus,Long> {
}
