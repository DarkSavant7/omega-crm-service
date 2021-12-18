package ru.darksavant.omegacrmservice.common.services.implimentation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.darksavant.omegacrmservice.common.entities.CalculationItems;
import ru.darksavant.omegacrmservice.common.entities.Good;
import ru.darksavant.omegacrmservice.common.repositories.CalculationItemsRepository;
import ru.darksavant.omegacrmservice.common.services.interfaces.CalculationItemsService;
import ru.darksavant.omegacrmservice.errors.ResourceNotFoundException;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class CalculationItemsServiceImpl implements CalculationItemsService {
    private final CalculationItemsRepository repository;

    public CalculationItems findByID(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Calculation Items not found"));
    }

    public CalculationItems findByGood(Good good){
        return repository.findByGood(good).orElseThrow(() -> new ResourceNotFoundException("Calculation Items not found"));
    }
    public CalculationItems findByQuantity(BigDecimal quantity){
        return repository.findByQuantity(quantity).orElseThrow(() -> new ResourceNotFoundException("Calculation Items not found"));
    }

    public CalculationItems save(CalculationItems item) {
        return repository.save(item);
    }

    public void delete(CalculationItems item) {
        repository.delete(item);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }


}
