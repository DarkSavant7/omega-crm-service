package ru.darksavant.omegacrmservice.common.services.interfaces;

import ru.darksavant.omegacrmservice.common.entities.WorkPlace;

public interface WorkPlaceService {

    WorkPlace findByTitle(String name);

    WorkPlace save(WorkPlace d);

    void delete(WorkPlace d);

    void deleteById(Long id);

}
