package ru.darksavant.omegacrmservice.common.entities.dto;

import lombok.*;
import ru.darksavant.omegacrmservice.common.entities.SalesItems;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class SalesItemsDto {

    private Long id;

    private SaleDto sale;

    private GoodDto good;

    private BigDecimal price;

    private BigDecimal quantity;

    public SalesItemsDto(SalesItems item) {
        this.id=item.getId();
        this.sale=new SaleDto(item.getSale());
        this.good=new GoodDto(item.getGood());
        this.price=item.getPrice();
        this.quantity=item.getQuantity();
    }
}
