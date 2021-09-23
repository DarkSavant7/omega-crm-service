package ru.darksavant.omegacrmservice.common.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.darksavant.omegacrmservice.common.entities.Calculation;
import ru.darksavant.omegacrmservice.common.entities.CalculationItems;
import ru.darksavant.omegacrmservice.common.entities.Good;
import ru.darksavant.omegacrmservice.common.repositories.CalculationItemsRepository;
import ru.darksavant.omegacrmservice.common.repositories.CalculationRepository;
import ru.darksavant.omegacrmservice.errors.ResourceNotFoundException;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class CalculationService {
    private final CalculationRepository repository;

    public Calculation findByID(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Calculation not found"));
    }

    public Calculation findByGood(Good good){
        return repository.findByGood(good).orElseThrow(() -> new ResourceNotFoundException("Calculation not found"));
    }
    public Calculation findByItems(List<CalculationItems> items){
        return repository.findByItems(items).orElseThrow(() -> new ResourceNotFoundException("Calculation Items not found"));
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
