package ru.darksavant.omegacrmservice.common.services.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import ru.darksavant.omegacrmservice.common.entities.Contact;
import ru.darksavant.omegacrmservice.common.entities.dto.UpdateContactDto;

import java.util.List;

public interface ContactsService {

    Contact findByFIO(String fio);

    List<Contact> findByPosition(String pos);

    Contact findByPrimaryPhone(int phone);

    Contact findByPrimaryEmail(String email);

    Contact findByMobilePhone(int phone);

    Contact findByWorkPhone(int phone);

    Contact findBySecondaryEmail(String email);

    Page<Contact> findAll(Specification<Contact> build, Integer page, Integer pageSize);

    Contact findByID(Long id);

    void delete(Contact item);

    void deleteById(Long id);

    void save(String fio, String position, Integer primaryPhone, Integer secondaryPhone, String primaryEmail, String secondaryEmail);

    Contact update(UpdateContactDto dto);
}
