package ru.darksavant.omegacrmservice.common.services.implimentation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.darksavant.omegacrmservice.common.entities.Good;
import ru.darksavant.omegacrmservice.common.entities.Sale;
import ru.darksavant.omegacrmservice.common.entities.SalesItems;
import ru.darksavant.omegacrmservice.common.repositories.SaleItemsRepository;
import ru.darksavant.omegacrmservice.common.services.interfaces.SaleItemsService;
import ru.darksavant.omegacrmservice.errors.ResourceNotFoundException;

@Service
@AllArgsConstructor
public class SaleItemsServiceImpl implements SaleItemsService {
    private final SaleItemsRepository repository;

    public SalesItems findBySale(Sale sale) {
        return repository.findBySale(sale).orElseThrow(() -> new ResourceNotFoundException("Sales Items not found"));
    }


    public SalesItems findByID(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Sales Items not found"));
    }

    public SalesItems findByGood(Good good) {
        return repository.findByGood(good).orElseThrow(() -> new ResourceNotFoundException("Sales Items not found"));
    }

    public SalesItems save(SalesItems item) {
        return repository.save(item);
    }

    public void delete(SalesItems item) {
        repository.delete(item);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }


}
