package ru.darksavant.omegacrmservice.common.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.darksavant.omegacrmservice.common.entities.Contact;
import ru.darksavant.omegacrmservice.common.repositories.ContactRepository;
import ru.darksavant.omegacrmservice.errors.ResourceNotFoundException;

@Service
@AllArgsConstructor
public class ContactsService {
    private final ContactRepository repository;

    public Contact findByFIO(String fio) {
        return repository.findByFIO(fio).orElseThrow(() -> new ResourceNotFoundException("Contact not found"));
    }


    public Contact findByPosition(String pos) {
        return repository.findContactByPosition(pos).orElseThrow(() -> new ResourceNotFoundException("Contact not found"));
    }


    public Contact findByPrimaryPhone(int phone) {
        return repository.findByPrimaryPhone(phone).orElseThrow(() -> new ResourceNotFoundException("Contact not found"));
    }


    public Contact findByPrimaryEmail(String email) {
        return repository.findByPrimaryEmail(email).orElseThrow(() -> new ResourceNotFoundException("Contact not found"));
    }


    public Contact findByMobilePhone(int phone) {
        return repository.findByMobilePhone(phone).orElseThrow(() -> new ResourceNotFoundException("Contact not found"));
    }


    public Contact findByWorkPhone(int phone) {
        return repository.findByWorkPhone(phone).orElseThrow(() -> new ResourceNotFoundException("Contact not found"));
    }


    public Contact findBySecondaryEmail(String email) {
        return repository.findBySecondaryEmail(email).orElseThrow(() -> new ResourceNotFoundException("Contact not found"));
    }


    public Contact findByID(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Calculation Items not found"));
    }

    public Contact save(Contact contact) {
        return repository.save(contact);
    }

    public void delete(Contact item) {
        repository.delete(item);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }


}
