package ru.darksavant.omegacrmservice.common.services.interfaces;

import ru.darksavant.omegacrmservice.common.entities.Contact;
import ru.darksavant.omegacrmservice.common.entities.Job;
import ru.darksavant.omegacrmservice.common.entities.User;
import ru.darksavant.omegacrmservice.common.entities.WorkPlace;

public interface JobService {

    Job findByID(Long id);

    Job findByService(ru.darksavant.omegacrmservice.common.entities.Service service);

    Job findByUser(User user);

    Job findByContact(Contact contact);

    Job findByWorkPlace(WorkPlace place);

    Job save(Job contact);

    void delete(Job item);

    void deleteById(Long id);

}
