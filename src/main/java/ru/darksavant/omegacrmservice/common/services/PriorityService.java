package ru.darksavant.omegacrmservice.common.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.darksavant.omegacrmservice.common.entities.Discount;
import ru.darksavant.omegacrmservice.common.entities.Priority;
import ru.darksavant.omegacrmservice.common.repositories.DiscountRepository;
import ru.darksavant.omegacrmservice.common.repositories.PriorityRepository;
import ru.darksavant.omegacrmservice.errors.ResourceNotFoundException;

@Service
@AllArgsConstructor
public class PriorityService {
    private final PriorityRepository priorityRepository;

    public Priority findByDescription(String name) {
        return priorityRepository.findByDescription(name).orElseThrow(() -> new ResourceNotFoundException("Priority not found"));
    }

    public Priority save(Priority d) {
        return priorityRepository.save(d);
    }

    public void delete(Priority d) {
        priorityRepository.delete(d);
    }

    public void deleteById(Long id){
        priorityRepository.deleteById(id);
    }


}
