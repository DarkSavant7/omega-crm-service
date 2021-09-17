package ru.darksavant.omegacrmservice.common.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.darksavant.omegacrmservice.common.entities.Discount;
import ru.darksavant.omegacrmservice.common.entities.Status;
import ru.darksavant.omegacrmservice.common.repositories.DiscountRepository;
import ru.darksavant.omegacrmservice.common.repositories.StatusRepository;
import ru.darksavant.omegacrmservice.errors.ResourceNotFoundException;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class StatusService {
    private final StatusRepository statusRepository;

    public Status findByName(String name) {
        return statusRepository.findByTitle(name).orElseThrow(() -> new ResourceNotFoundException("Status not found"));
    }

    public Status save(Status d) {
        return statusRepository.save(d);
    }

    public void delete(Status d) {
        statusRepository.delete(d);
    }

    public void deleteById(Long id){
        statusRepository.deleteById(id);
    }


}
