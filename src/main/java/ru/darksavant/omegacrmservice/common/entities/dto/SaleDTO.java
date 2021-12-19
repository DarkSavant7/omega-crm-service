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
public class SaleDTO {

    private Long id;

    private String saleDate;

    private BigDecimal totalAmount;

    private DiscountDTO discount;

    private PaymentTypeDTO type;

    private SaleStatusDTO status;

    private UserDTO saler;

    private ContactDTO buyer;

    private String createdAt;

    private String updatedAt;

    private List<SalesItemsDTO> items;

    public SaleDTO(Sale sale) {
        this.id = sale.getId();
        this.saleDate=sale.getSaleDate().toString();
        this.totalAmount=sale.getTotalAmount();
        this.discount=new DiscountDTO(sale.getDiscount());
        this.type=new PaymentTypeDTO(sale.getType());
        this.status=new SaleStatusDTO(sale.getStatus());
        this.saler=new UserDTO(sale.getSaler());
        this.buyer=new ContactDTO(sale.getBuyer());
        this.createdAt=sale.getCreatedAt().toString();
        this.updatedAt=sale.getUpdatedAt().toString();
    }
}
