package ru.darksavant.omegacrmservice.common.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.darksavant.omegacrmservice.common.entities.Sale;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class SaleDto {

    private Long id;

    private String saleDate;

    private BigDecimal totalAmount;

    private DiscountDto discount;

    private PaymentTypeDto type;

    private SaleStatusDto status;

    private UserDto saler;

    private ContactDto buyer;

    private String createdAt;

    private String updatedAt;

    private List<SalesItemsDto> items;

    public SaleDto(Sale sale) {
        this.id = sale.getId();
        this.saleDate=sale.getSaleDate().toString();
        this.totalAmount=sale.getTotalAmount();
        this.discount=new DiscountDto(sale.getDiscount());
        this.type=new PaymentTypeDto(sale.getType());
        this.status=new SaleStatusDto(sale.getStatus());
        this.saler=new UserDto(sale.getSaler());
        this.buyer=new ContactDto(sale.getBuyer());
        this.createdAt=sale.getCreatedAt().toString();
        this.updatedAt=sale.getUpdatedAt().toString();
    }
}
