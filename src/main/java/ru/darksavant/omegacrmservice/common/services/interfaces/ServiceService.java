package ru.darksavant.omegacrmservice.common.services.interfaces;

import java.math.BigDecimal;

public interface ServiceService {

    ru.darksavant.omegacrmservice.common.entities.Service findByDescription(String name);

    ru.darksavant.omegacrmservice.common.entities.Service findByTitle(String name);

    ru.darksavant.omegacrmservice.common.entities.Service findByPrice(BigDecimal price);

    ru.darksavant.omegacrmservice.common.entities.Service save(ru.darksavant.omegacrmservice.common.entities.Service d);

    void delete(ru.darksavant.omegacrmservice.common.entities.Service d);

    void deleteById(Long id);


}
