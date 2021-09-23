package ru.darksavant.omegacrmservice.common.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.darksavant.omegacrmservice.common.entities.Contact;
import ru.darksavant.omegacrmservice.common.entities.Job;
import ru.darksavant.omegacrmservice.common.entities.User;
import ru.darksavant.omegacrmservice.common.entities.WorkPlace;
import ru.darksavant.omegacrmservice.common.repositories.JobRepository;
import ru.darksavant.omegacrmservice.errors.ResourceNotFoundException;



@Service
@AllArgsConstructor
public class JobService {
    private final JobRepository repository;

    public Job findByID(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Job not found"));
    }
    Job findByService(ru.darksavant.omegacrmservice.common.entities.Service service){
        return repository.findByService(service).orElseThrow(() -> new ResourceNotFoundException("Job not found"));
    }
    Job findByUser(User user){
        return repository.findByUser(user).orElseThrow(() -> new ResourceNotFoundException("Job not found"));
    }

    Job findByContact(Contact contact){
        return repository.findByContact(contact).orElseThrow(() -> new ResourceNotFoundException("Job not found"));
    }

    Job findByWorkPlace(WorkPlace place){
        return repository.findByWorkPlace(place).orElseThrow(() -> new ResourceNotFoundException("Job not found"));
    }

    public Job save(Job contact) {
        return repository.save(contact);
    }

    public void delete(Job item) {
        repository.delete(item);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }


}
