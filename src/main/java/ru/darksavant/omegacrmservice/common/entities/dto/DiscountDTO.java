package ru.darksavant.omegacrmservice.common.entities.dto;

import lombok.*;
import ru.darksavant.omegacrmservice.common.entities.Discount;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class DiscountDTO {

    private String name;

    private BigDecimal amount;

    public DiscountDTO(Discount discount) {
        this.name=discount.getName();
        this.amount=discount.getAmount();
    }
}
