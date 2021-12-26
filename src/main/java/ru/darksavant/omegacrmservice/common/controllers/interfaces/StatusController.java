package ru.darksavant.omegacrmservice.common.controllers.interfaces;

import ru.darksavant.omegacrmservice.common.entities.Status;

public interface StatusController {

    Status findByName(String name);

    Status save(Status d);

    void delete(Status d);

    void deleteById(Long id);


}
