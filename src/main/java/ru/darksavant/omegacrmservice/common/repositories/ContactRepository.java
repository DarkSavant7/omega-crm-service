package ru.darksavant.omegacrmservice.common.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.darksavant.omegacrmservice.common.entities.Contact;

import java.util.Optional;

public interface ContactRepository extends JpaRepository<Contact,Long> {
    Optional<Contact> findByFIO(String fio);

    Optional<Contact> findContactByPosition(String pos);

    Optional<Contact> findByPrimaryPhone(int phone);

    Optional<Contact> findByPrimaryEmail(String email);

    Optional<Contact> findByMobilePhone(int phone);

    Optional<Contact> findByWorkPhone(int phone);

    Optional<Contact> findBySecondaryEmail(String email);
}
