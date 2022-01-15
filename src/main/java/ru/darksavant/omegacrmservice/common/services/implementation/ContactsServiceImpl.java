package ru.darksavant.omegacrmservice.common.services.implementation;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.darksavant.omegacrmservice.common.entities.Contact;
import ru.darksavant.omegacrmservice.common.entities.dto.UpdateContactDto;
import ru.darksavant.omegacrmservice.common.repositories.ContactRepository;
import ru.darksavant.omegacrmservice.common.services.interfaces.ContactsService;
import ru.darksavant.omegacrmservice.errors.BadRequestException;
import ru.darksavant.omegacrmservice.errors.ResourceNotFoundException;
import ru.darksavant.omegacrmservice.errors.StorageException;

import java.util.List;

@Service
@AllArgsConstructor
public class ContactsServiceImpl implements ContactsService {
    private final ContactRepository repository;

    @Override
    public Contact findByFIO(String fio) {
        return repository.findByFIO(fio).orElseThrow(() -> new ResourceNotFoundException("Контакт не найден по - " + fio));
    }

    @Override
    public List<Contact> findByPosition(String pos) {
        return repository.findAllByPosition(pos);
    }

    @Override
    public Contact findByPrimaryPhone(int phone) {
        return repository.findByPrimaryPhone(phone).orElseThrow(() -> new ResourceNotFoundException("Контакт не найден по - " + phone));
    }

    @Override
    public Contact findByPrimaryEmail(String email) {
        return repository.findByPrimaryEmail(email).orElseThrow(() -> new ResourceNotFoundException("Контакт не найден по - " + email));
    }

    @Override
    public Contact findByMobilePhone(int phone) {
        return repository.findByMobilePhone(phone).orElseThrow(() -> new ResourceNotFoundException("Контакт не найден по - " + phone));
    }

    @Override
    public Contact findByWorkPhone(int phone) {
        return repository.findByWorkPhone(phone).orElseThrow(() -> new ResourceNotFoundException("Контакт не найден по - " + phone));
    }

    @Override
    public Contact findBySecondaryEmail(String email) {
        return repository.findBySecondaryEmail(email).orElseThrow(() -> new ResourceNotFoundException("Контакт не найден по - " + email));
    }

    @Override
    public Page<Contact> findAll(Specification<Contact> build, Integer page, Integer pageSize) {
        return repository.findAll(build, PageRequest.of(page - 1, pageSize));
    }

    @Override
    public Contact findByID(Long id) throws ResourceNotFoundException {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Контакт не найден по - " + id));
    }

    @Override
    @Transactional
    public void delete(Contact item) {
        repository.delete(item);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public void save(String fio, String position, Integer primaryPhone, Integer secondaryPhone, String primaryEmail, String secondaryEmail) throws BadRequestException {
        if (repository.findByFIO(fio).isPresent()) {
            throw new BadRequestException("Контакт с такими ФИО уже существует");
        }
        if (repository.findByPrimaryPhone(primaryPhone).isPresent()) {
            throw new BadRequestException("Контакт с такими телефонным номером уже существует");
        }
        if (repository.findByPrimaryEmail(primaryEmail).isPresent()) {
            throw new BadRequestException("Контакт с такими email уже существует");
        }
        Contact newContact = new Contact();
        newContact.setFIO(fio);
        newContact.setPosition(position);
        newContact.setPrimaryPhone(primaryPhone);
        newContact.setPrimaryEmail(primaryEmail);
        if (secondaryEmail != null) {
            newContact.setSecondaryEmail(secondaryEmail);
        }
        if (secondaryPhone != null) {
            newContact.setMobilePhone(secondaryPhone);
        }
        repository.save(newContact);
    }

    @Override
    @Transactional
    public Contact update(UpdateContactDto dto) {
        Contact updateContact = repository.findById(dto.getId()).orElseThrow(() -> new BadRequestException("Контакт с id - " + dto.getId() + " не найден"));
        if (dto.getFIO() != null) {
            if (repository.findByFIO(dto.getFIO()).isPresent()) {
                throw new BadRequestException("Контакт с такими ФИО уже существует");
            } else {
                updateContact.setFIO(dto.getFIO());
            }
        }
        if (dto.getPosition() != null) {
            updateContact.setPosition(dto.getPosition());
        }
        if (dto.getPrimaryPhone() != null) {
            if (repository.findByPrimaryPhone(dto.getPrimaryPhone()).isPresent()) {
                throw new BadRequestException("Контакт с такими телефонным номером уже существует");
            } else {
                updateContact.setPrimaryPhone(dto.getPrimaryPhone());
            }
        }
        if (dto.getMobilePhone() != null) {
            updateContact.setMobilePhone(dto.getMobilePhone());
        }
        if (dto.getWorkPhone() != null) {
            updateContact.setWorkPhone(dto.getWorkPhone());
        }
        if (dto.getPrimaryEmail() != null) {
            if (repository.findByPrimaryEmail(dto.getPrimaryEmail()).isPresent()) {
                throw new BadRequestException("Контакт с такими email уже существует");
            } else {
                updateContact.setPrimaryEmail(dto.getPrimaryEmail());
            }
        }
        if (dto.getSecondaryEmail()!=null){
            updateContact.setSecondaryEmail(dto.getSecondaryEmail());
        }
        repository.save(updateContact);
        return repository.findById(dto.getId()).orElseThrow(()->new StorageException("Ошибка обновления данных контакта"));
    }


}
