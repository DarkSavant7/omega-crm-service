package ru.darksavant.omegacrmservice.common.services.implimentation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.darksavant.omegacrmservice.common.entities.Contact;
import ru.darksavant.omegacrmservice.common.entities.Producer;
import ru.darksavant.omegacrmservice.common.repositories.ProducerRepository;
import ru.darksavant.omegacrmservice.common.services.interfaces.ProducerService;
import ru.darksavant.omegacrmservice.errors.ResourceNotFoundException;

@Service
@AllArgsConstructor
public class ProducerServiceImpl implements ProducerService {
    private final ProducerRepository  repository;

    public Producer findByID(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Producer not found"));
    }

    public Producer findByContact(Contact c){
        return repository.findByContact(c).orElseThrow(() -> new ResourceNotFoundException("Producer not found"));
    }

    public Producer findByDesignation(String d){
        return repository.findByDesignation(d).orElseThrow(() -> new ResourceNotFoundException("Producer not found"));
    }

    public Producer findByINN(long inn){
        return repository.findByINN(inn).orElseThrow(() -> new ResourceNotFoundException("Producer not found"));
    }

    public Producer  save(Producer  item) {
        return repository.save(item);
    }

    public void delete(Producer  item) {
        repository.delete(item);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }


}
