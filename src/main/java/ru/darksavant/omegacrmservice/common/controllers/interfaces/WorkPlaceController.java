package ru.darksavant.omegacrmservice.common.controllers.interfaces;

import ru.darksavant.omegacrmservice.common.entities.WorkPlace;

public interface WorkPlaceController {

    WorkPlace findByTitle(String name);

    WorkPlace save(WorkPlace d);

    void delete(WorkPlace d);

    void deleteById(Long id);

}
