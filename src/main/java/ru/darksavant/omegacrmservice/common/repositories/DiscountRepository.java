package ru.darksavant.omegacrmservice.common.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.darksavant.omegacrmservice.common.entities.Discount;

public interface DiscountRepository extends JpaRepository<Discount,Long> {
}
