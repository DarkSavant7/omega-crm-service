package ru.darksavant.omegacrmservice.common.entities.dto;

import lombok.*;
import ru.darksavant.omegacrmservice.common.entities.Warehouse;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class WarehouseDto {

    private String description;

    public WarehouseDto(Warehouse warehouse) {
        this.description=warehouse.getDescription();
    }
}
