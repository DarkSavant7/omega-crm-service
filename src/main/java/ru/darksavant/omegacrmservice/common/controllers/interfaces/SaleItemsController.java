package ru.darksavant.omegacrmservice.common.controllers.interfaces;

import ru.darksavant.omegacrmservice.common.entities.Good;
import ru.darksavant.omegacrmservice.common.entities.Sale;
import ru.darksavant.omegacrmservice.common.entities.SalesItems;

public interface SaleItemsController {

    SalesItems findBySale(Sale sale);

    SalesItems findByID(Long id);

    SalesItems findByGood(Good good);

    SalesItems save(SalesItems item);

    void delete(SalesItems item);

    void deleteById(Long id);

}
