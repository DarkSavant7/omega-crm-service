package ru.darksavant.omegacrmservice.common.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.darksavant.omegacrmservice.common.entities.Good;

import java.util.Optional;

public interface GoodRepository extends JpaRepository<Good,Long> {

    Optional<Good> findGoodByVendorCode(String code);

    Optional<Good> findGoodByTitle(String title);


}
