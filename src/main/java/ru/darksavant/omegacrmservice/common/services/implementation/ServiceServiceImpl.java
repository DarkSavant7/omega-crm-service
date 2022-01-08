package ru.darksavant.omegacrmservice.common.services.implementation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.darksavant.omegacrmservice.common.repositories.ServiceRepository;
import ru.darksavant.omegacrmservice.common.services.interfaces.ServiceService;
import ru.darksavant.omegacrmservice.errors.ResourceNotFoundException;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class ServiceServiceImpl implements ServiceService {
    private final ServiceRepository serviceRepository;

    public ru.darksavant.omegacrmservice.common.entities.Service findByDescription(String name) {
        return serviceRepository.findByDescription(name).orElseThrow(() -> new ResourceNotFoundException("Service not found"));
    }
    public ru.darksavant.omegacrmservice.common.entities.Service findByTitle(String name) {
        return serviceRepository.findByTitle(name).orElseThrow(() -> new ResourceNotFoundException("Service not found"));
    }

    public ru.darksavant.omegacrmservice.common.entities.Service findByPrice(BigDecimal price) {
        return serviceRepository.findByPrice(price).orElseThrow(() -> new ResourceNotFoundException("Service not found"));
    }

    public ru.darksavant.omegacrmservice.common.entities.Service save(ru.darksavant.omegacrmservice.common.entities.Service d) {
        return serviceRepository.save(d);
    }

    public void delete(ru.darksavant.omegacrmservice.common.entities.Service  d) {
        serviceRepository.delete(d);
    }

    public void deleteById(Long id) {
        serviceRepository.deleteById(id);
    }


}
