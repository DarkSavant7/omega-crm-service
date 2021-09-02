package ru.darksavant.omegacrmservice.common.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.darksavant.omegacrmservice.common.entities.Discount;
@Repository
public interface DiscountRepository extends JpaRepository<Discount,Long> {
}
