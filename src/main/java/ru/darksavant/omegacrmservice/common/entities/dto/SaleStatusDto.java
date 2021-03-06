package ru.darksavant.omegacrmservice.common.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.darksavant.omegacrmservice.common.entities.SaleStatus;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class SaleStatusDto {

    private String name;

    private String createdAt;

    private String  updatedAt;

    public SaleStatusDto(SaleStatus saleStatus) {
        this.name=saleStatus.getName();
        this.createdAt=saleStatus.getCreatedAt().toString();
        this.updatedAt=saleStatus.getUpdatedAt().toString();
    }
}
