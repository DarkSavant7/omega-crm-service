package ru.darksavant.omegacrmservice.common.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.darksavant.omegacrmservice.common.entities.Contact;
import ru.darksavant.omegacrmservice.common.entities.Producer;

import java.util.Optional;

public interface ProducerRepository extends JpaRepository<Producer,Long> {
    Optional<Producer> findByContact(Contact c);

    Optional<Producer> findByDesignation(String d);

    Optional<Producer> findByINN(long inn);

}
