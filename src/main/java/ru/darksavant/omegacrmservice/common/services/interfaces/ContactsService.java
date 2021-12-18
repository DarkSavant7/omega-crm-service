package ru.darksavant.omegacrmservice.common.services.interfaces;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.darksavant.omegacrmservice.common.entities.Contact;
import ru.darksavant.omegacrmservice.common.repositories.ContactRepository;
import ru.darksavant.omegacrmservice.errors.ResourceNotFoundException;

public interface ContactsService {

    Contact findByFIO(String fio);

    Contact findByPosition(String pos);

    Contact findByPrimaryPhone(int phone);

    Contact findByPrimaryEmail(String email);

    Contact findByMobilePhone(int phone);

    Contact findByWorkPhone(int phone);

    Contact findBySecondaryEmail(String email);

    Contact findByID(Long id);

    Contact save(Contact contact);

    void delete(Contact item);

    void deleteById(Long id);

}
