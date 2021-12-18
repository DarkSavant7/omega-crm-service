package ru.darksavant.omegacrmservice.common.services.interfaces;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.darksavant.omegacrmservice.common.entities.CalculationItems;
import ru.darksavant.omegacrmservice.common.entities.Good;
import ru.darksavant.omegacrmservice.common.repositories.CalculationItemsRepository;
import ru.darksavant.omegacrmservice.errors.ResourceNotFoundException;

import java.math.BigDecimal;

public interface CalculationItemsService {


    CalculationItems findByID(Long id);

    CalculationItems findByGood(Good good);

    CalculationItems findByQuantity(BigDecimal quantity);

    CalculationItems save(CalculationItems item);

    void delete(CalculationItems item);

    void deleteById(Long id);


}
