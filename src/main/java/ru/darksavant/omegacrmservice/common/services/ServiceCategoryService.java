package ru.darksavant.omegacrmservice.common.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.darksavant.omegacrmservice.common.entities.ServiceCategory;
import ru.darksavant.omegacrmservice.common.repositories.ServiceCategoryRepository;
import ru.darksavant.omegacrmservice.common.repositories.ServiceRepository;
import ru.darksavant.omegacrmservice.errors.ResourceNotFoundException;

@Service
@AllArgsConstructor
public class ServiceCategoryService {
    private final ServiceCategoryRepository serviceCategoryRepository;

    public ServiceCategory findByDescription(String name) {
        return serviceCategoryRepository.findByName(name).orElseThrow(() -> new ResourceNotFoundException("ServiceCategory not found"));
    }

    public ServiceCategory save(ServiceCategory d) {
        return serviceCategoryRepository.save(d);
    }

    public void delete(ServiceCategory d) {
        serviceCategoryRepository.delete(d);
    }

    public void deleteById(Long id) {
        serviceCategoryRepository.deleteById(id);
    }


}
