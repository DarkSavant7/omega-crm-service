package ru.darksavant.omegacrmservice.common.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.darksavant.omegacrmservice.common.entities.ServiceCategory;

import java.util.Optional;


@Repository
public interface ServiceCategoryRepository extends JpaRepository<ServiceCategory,Long> {

    Optional<ServiceCategory> findByName(String name);
}
