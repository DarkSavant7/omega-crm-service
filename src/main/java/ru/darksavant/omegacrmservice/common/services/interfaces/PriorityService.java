package ru.darksavant.omegacrmservice.common.services.interfaces;

import ru.darksavant.omegacrmservice.common.entities.Priority;


public interface PriorityService {

    Priority findByDescription(String name);

    Priority save(Priority d);

    void delete(Priority d);

    void deleteById(Long id);

}
