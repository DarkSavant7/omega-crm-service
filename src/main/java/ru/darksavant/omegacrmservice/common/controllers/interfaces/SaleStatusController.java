package ru.darksavant.omegacrmservice.common.controllers.interfaces;

import ru.darksavant.omegacrmservice.common.entities.SaleStatus;

public interface SaleStatusController {

    SaleStatus findByDescription(String name);

    SaleStatus save(SaleStatus d);

    void delete(SaleStatus d);

    void deleteById(Long id);

}
