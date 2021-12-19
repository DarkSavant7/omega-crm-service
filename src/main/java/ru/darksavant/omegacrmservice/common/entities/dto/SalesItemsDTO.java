package ru.darksavant.omegacrmservice.common.entities.dto;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import ru.darksavant.omegacrmservice.common.entities.SalesItems;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class SalesItemsDTO {

    private Long id;

    private SaleDTO sale;

    private GoodDTO good;

    private BigDecimal price;

    private BigDecimal quantity;

    public SalesItemsDTO(SalesItems item) {
        this.id=item.getId();
        this.sale=new SaleDTO(item.getSale());
        this.good=new GoodDTO(item.getGood());
        this.price=item.getPrice();
        this.quantity=item.getQuantity();
    }
}
