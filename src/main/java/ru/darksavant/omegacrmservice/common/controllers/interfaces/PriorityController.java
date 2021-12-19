package ru.darksavant.omegacrmservice.common.controllers.interfaces;

import ru.darksavant.omegacrmservice.common.entities.Priority;


public interface PriorityController {

    Priority findByDescription(String name);

    Priority save(Priority d);

    void delete(Priority d);

    void deleteById(Long id);

}
