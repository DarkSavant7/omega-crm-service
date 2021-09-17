package ru.darksavant.omegacrmservice.common.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.darksavant.omegacrmservice.common.entities.Good;

import java.util.Optional;
@Repository
public interface GoodRepository extends JpaRepository<Good,Long> {

    Optional<Good> findGoodByVendorCode(int code);

    Optional<Good> findGoodByTitle(String title);

}
