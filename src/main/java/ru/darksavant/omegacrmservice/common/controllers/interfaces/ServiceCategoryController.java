package ru.darksavant.omegacrmservice.common.controllers.interfaces;

import ru.darksavant.omegacrmservice.common.entities.ServiceCategory;

public interface ServiceCategoryController {

    ServiceCategory findByDescription(String name);

    ServiceCategory save(ServiceCategory d);

    void delete(ServiceCategory d);

    void deleteById(Long id);

}
