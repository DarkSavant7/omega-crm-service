package ru.darksavant.omegacrmservice.common.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ru.darksavant.omegacrmservice.common.entities.Contact;
import ru.darksavant.omegacrmservice.common.entities.Good;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long>, JpaSpecificationExecutor<Contact> {
    Optional<Contact> findByFIO(String fio);

    List<Contact> findAllByPosition(String pos);

    Optional<Contact> findByPrimaryPhone(int phone);

    Optional<Contact> findByPrimaryEmail(String email);

    Optional<Contact> findByMobilePhone(int phone);

    Optional<Contact> findByWorkPhone(int phone);

    Optional<Contact> findBySecondaryEmail(String email);
}
