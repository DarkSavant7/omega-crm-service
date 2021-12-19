package ru.darksavant.omegacrmservice.common.services.implementation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.darksavant.omegacrmservice.common.entities.SaleStatus;
import ru.darksavant.omegacrmservice.common.repositories.SaleStatusRepository;
import ru.darksavant.omegacrmservice.common.services.interfaces.SaleStatusService;
import ru.darksavant.omegacrmservice.errors.ResourceNotFoundException;

@Service
@AllArgsConstructor
public class SaleStatusServiceImpl implements SaleStatusService {
    private final SaleStatusRepository saleStatusRepository;

    public SaleStatus findByDescription(String name) {
        return saleStatusRepository.findByName(name).orElseThrow(() -> new ResourceNotFoundException("Sale status not found"));
    }

    public SaleStatus save(SaleStatus d) {
        return saleStatusRepository.save(d);
    }

    public void delete(SaleStatus d) {
        saleStatusRepository.delete(d);
    }

    public void deleteById(Long id) {
        saleStatusRepository.deleteById(id);
    }


}
