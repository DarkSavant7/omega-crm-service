package ru.darksavant.omegacrmservice.common.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.darksavant.omegacrmservice.common.entities.Priority;
import ru.darksavant.omegacrmservice.common.entities.SaleStatus;
import ru.darksavant.omegacrmservice.common.repositories.PriorityRepository;
import ru.darksavant.omegacrmservice.common.repositories.SaleStatusRepository;
import ru.darksavant.omegacrmservice.errors.ResourceNotFoundException;

@Service
@AllArgsConstructor
public class SaleStatusService {
    private final SaleStatusRepository saleStatusRepository;

    public SaleStatus findByDescription(String name) {
        return saleStatusRepository.findByName(name).orElseThrow(() -> new ResourceNotFoundException("Sale status not found"));
    }

    public SaleStatus save(SaleStatus d) {
        return saleStatusRepository.save(d);
    }

    public void deleteDiscount(SaleStatus d) {
        saleStatusRepository.delete(d);
    }

    public void deleteDiscountById(Long id) {
        saleStatusRepository.deleteById(id);
    }


}
