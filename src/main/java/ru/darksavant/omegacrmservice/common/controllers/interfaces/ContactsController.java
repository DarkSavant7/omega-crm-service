package ru.darksavant.omegacrmservice.common.controllers.interfaces;

import ru.darksavant.omegacrmservice.common.entities.Contact;

public interface ContactsController {

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
