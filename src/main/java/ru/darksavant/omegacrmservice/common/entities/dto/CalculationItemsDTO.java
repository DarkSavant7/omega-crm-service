package ru.darksavant.omegacrmservice.common.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.darksavant.omegacrmservice.common.entities.CalculationItems;
import ru.darksavant.omegacrmservice.common.entities.Good;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class CalculationItemsDTO {

    private GoodDTO good;

    private BigDecimal quantity;

    public CalculationItemsDTO(CalculationItems items) {
        good=new GoodDTO(items.getGood());
        quantity=items.getQuantity();
    }
}
