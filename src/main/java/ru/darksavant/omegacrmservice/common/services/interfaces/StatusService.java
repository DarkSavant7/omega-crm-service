package ru.darksavant.omegacrmservice.common.services.interfaces;

import ru.darksavant.omegacrmservice.common.entities.Status;

public interface StatusService {

    Status findByName(String name);

    Status save(Status d);

    void delete(Status d);

    void deleteById(Long id);


}
