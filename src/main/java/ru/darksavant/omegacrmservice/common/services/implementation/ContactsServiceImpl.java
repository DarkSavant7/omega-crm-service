package ru.darksavant.omegacrmservice.common.services.implementation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.darksavant.omegacrmservice.common.entities.Contact;
import ru.darksavant.omegacrmservice.common.repositories.ContactRepository;
import ru.darksavant.omegacrmservice.common.services.interfaces.ContactsService;
import ru.darksavant.omegacrmservice.errors.BadRequestException;
import ru.darksavant.omegacrmservice.errors.ResourceNotFoundException;

@Service
@AllArgsConstructor
public class ContactsServiceImpl implements ContactsService {
    private final ContactRepository repository;

    public Contact findByFIO(String fio) {
        return repository.findByFIO(fio).orElseThrow(() -> new ResourceNotFoundException("Контакт не найден по - "+fio));
    }


    public Contact findByPosition(String pos) {
        return repository.findContactByPosition(pos).orElseThrow(() -> new ResourceNotFoundException("Контакт не найден по - "+pos));
    }


    public Contact findByPrimaryPhone(int phone) {
        return repository.findByPrimaryPhone(phone).orElseThrow(() -> new ResourceNotFoundException("Контакт не найден по - "+phone));
    }


    public Contact findByPrimaryEmail(String email) {
        return repository.findByPrimaryEmail(email).orElseThrow(() -> new ResourceNotFoundException("Контакт не найден по - "+email));
    }


    public Contact findByMobilePhone(int phone) {
        return repository.findByMobilePhone(phone).orElseThrow(() -> new ResourceNotFoundException("Контакт не найден по - "+phone));
    }


    public Contact findByWorkPhone(int phone) {
        return repository.findByWorkPhone(phone).orElseThrow(() -> new ResourceNotFoundException("Контакт не найден по - "+phone));
    }


    public Contact findBySecondaryEmail(String email) {
        return repository.findBySecondaryEmail(email).orElseThrow(() -> new ResourceNotFoundException("Контакт не найден по - "+email));
    }


    public Contact findByID(Long id) throws ResourceNotFoundException{
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Контакт не найден по - "+id));
    }

    public void delete(Contact item) {
        repository.delete(item);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public void save(String fio, String position, Integer primaryPhone, Integer secondaryPhone, String primaryEmail, String secondaryEmail) throws BadRequestException {
        if (repository.findByFIO(fio).isPresent()){
            throw new BadRequestException("Контакт с такими ФИО уже существует");
        }
        if (repository.findByPrimaryPhone(primaryPhone).isPresent()){
            throw new BadRequestException("Контакт с такими телефонным номером уже существует");
        }
        if (repository.findByPrimaryEmail(primaryEmail).isPresent()){
            throw new BadRequestException("Контакт с такими email уже существует");
        }
        Contact newContact = new Contact();
        newContact.setFIO(fio);
        newContact.setPosition(position);
        newContact.setPrimaryPhone(primaryPhone);
        newContact.setPrimaryEmail(primaryEmail);
        if (secondaryEmail!=null){
            newContact.setSecondaryEmail(secondaryEmail);
        }
        if(secondaryPhone!=null){
            newContact.setMobilePhone(secondaryPhone);
        }
        repository.save(newContact);
    }


}
