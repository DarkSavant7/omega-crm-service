package ru.darksavant.omegacrmservice.common.services.interfaces;

import ru.darksavant.omegacrmservice.common.entities.Contact;
import ru.darksavant.omegacrmservice.common.entities.Producer;

public interface ProducerService {

    Producer findByID(Long id);

    Producer findByContact(Contact c);

    Producer findByDesignation(String d);

    Producer findByINN(long inn);

    Producer save(Producer item);

    void delete(Producer item);

    void deleteById(Long id);

}
