package ru.darksavant.omegacrmservice.common.services.implementation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.darksavant.omegacrmservice.common.entities.Calculation;
import ru.darksavant.omegacrmservice.common.entities.Good;
import ru.darksavant.omegacrmservice.common.repositories.CalculationRepository;
import ru.darksavant.omegacrmservice.common.services.interfaces.CalculationService;
import ru.darksavant.omegacrmservice.errors.ResourceNotFoundException;

@Service
@AllArgsConstructor
public class CalculationServiceImpl implements CalculationService {
    private final CalculationRepository repository;

    public Calculation findByID(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Calculation not found"));
    }

    public Calculation findByGood(Good good){
        return repository.findByGood(good).orElseThrow(() -> new ResourceNotFoundException("Calculation not found"));
    }

    public Calculation save(Calculation item) {
        return repository.save(item);
    }

    public void delete(Calculation item) {
        repository.delete(item);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }


}
