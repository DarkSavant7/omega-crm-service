package ru.darksavant.omegacrmservice.common.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.darksavant.omegacrmservice.common.entities.CalculationItems;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class CalculationItemsDto {

    private GoodDto good;

    private BigDecimal quantity;

    public CalculationItemsDto(CalculationItems items) {
        good=new GoodDto(items.getGood());
        quantity=items.getQuantity();
    }
}
