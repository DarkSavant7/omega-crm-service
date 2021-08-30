package ru.darksavant.omegacrmservice.common.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.darksavant.omegacrmservice.common.entities.PaymentType;

public interface PaymentTypeRepository extends JpaRepository<PaymentType,Long> {
}
