package ru.darksavant.omegacrmservice.common.services.interfaces;

import ru.darksavant.omegacrmservice.common.entities.Calculation;
import ru.darksavant.omegacrmservice.common.entities.Good;

public interface CalculationService {

     Calculation findByID(Long id);

     Calculation findByGood(Good good);

     Calculation save(Calculation item);

     void delete(Calculation item);

     void deleteById(Long id);

}
