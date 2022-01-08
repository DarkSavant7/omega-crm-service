package ru.darksavant.omegacrmservice.common.services.interfaces;

import ru.darksavant.omegacrmservice.common.entities.CalculationItems;
import ru.darksavant.omegacrmservice.common.entities.Good;

import java.math.BigDecimal;

public interface CalculationItemsService {


    CalculationItems findByID(Long id);

    CalculationItems findByGood(Good good);

    CalculationItems findByQuantity(BigDecimal quantity);

    CalculationItems save(CalculationItems item);

    void delete(CalculationItems item);

    void deleteById(Long id);

}
