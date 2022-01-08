package ru.darksavant.omegacrmservice.common.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.darksavant.omegacrmservice.common.entities.Discount;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public interface DiscountRepository extends JpaRepository<Discount,Long> {
    Optional<Discount> findByName(String name);

    Optional<Discount> findByAmount(BigDecimal amount);

}
