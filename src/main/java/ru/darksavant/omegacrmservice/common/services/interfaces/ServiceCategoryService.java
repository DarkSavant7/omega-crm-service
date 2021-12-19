package ru.darksavant.omegacrmservice.common.services.interfaces;

import ru.darksavant.omegacrmservice.common.entities.ServiceCategory;

public interface ServiceCategoryService {

    ServiceCategory findByDescription(String name);

    ServiceCategory save(ServiceCategory d);

    void delete(ServiceCategory d);

    void deleteById(Long id);

}
