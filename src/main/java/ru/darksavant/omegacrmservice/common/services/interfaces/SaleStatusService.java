package ru.darksavant.omegacrmservice.common.services.interfaces;

import ru.darksavant.omegacrmservice.common.entities.SaleStatus;

public interface SaleStatusService {

    SaleStatus findByDescription(String name);

    SaleStatus save(SaleStatus d);

    void delete(SaleStatus d);

    void deleteById(Long id);

}
