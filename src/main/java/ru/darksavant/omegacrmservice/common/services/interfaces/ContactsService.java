package ru.darksavant.omegacrmservice.common.services.interfaces;

import ru.darksavant.omegacrmservice.common.entities.Contact;

public interface ContactsService {

    Contact findByFIO(String fio);

    Contact findByPosition(String pos);

    Contact findByPrimaryPhone(int phone);

    Contact findByPrimaryEmail(String email);

    Contact findByMobilePhone(int phone);

    Contact findByWorkPhone(int phone);

    Contact findBySecondaryEmail(String email);

    Contact findByID(Long id);

    void delete(Contact item);

    void deleteById(Long id);

    void save(String fio, String position, Integer primaryPhone, Integer secondaryPhone, String primaryEmail, String secondaryEmail);
}
