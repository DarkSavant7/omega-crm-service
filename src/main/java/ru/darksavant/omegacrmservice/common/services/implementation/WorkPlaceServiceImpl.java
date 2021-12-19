package ru.darksavant.omegacrmservice.common.services.implementation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.darksavant.omegacrmservice.common.entities.WorkPlace;
import ru.darksavant.omegacrmservice.common.repositories.WorkPlaceRepository;
import ru.darksavant.omegacrmservice.common.services.interfaces.WorkPlaceService;
import ru.darksavant.omegacrmservice.errors.ResourceNotFoundException;

@Service
@AllArgsConstructor
public class WorkPlaceServiceImpl implements WorkPlaceService {
    private final WorkPlaceRepository workPlaceRepository;

    public WorkPlace findByTitle(String name) {
        return workPlaceRepository.findByTitle(name).orElseThrow(() -> new ResourceNotFoundException("Work place not found"));
    }

    public WorkPlace save(WorkPlace d) {
        return workPlaceRepository.save(d);
    }

    public void delete(WorkPlace d) {
        workPlaceRepository.delete(d);
    }

    public void deleteById(Long id) {
        workPlaceRepository.deleteById(id);
    }


}
