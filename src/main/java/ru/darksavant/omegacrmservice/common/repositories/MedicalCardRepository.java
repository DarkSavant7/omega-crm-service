package ru.darksavant.omegacrmservice.common.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.darksavant.omegacrmservice.common.entities.MedicalCard;

public interface MedicalCardRepository extends JpaRepository<MedicalCard,Long> {
}
