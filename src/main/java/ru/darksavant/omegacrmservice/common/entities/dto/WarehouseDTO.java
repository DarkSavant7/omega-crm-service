package ru.darksavant.omegacrmservice.common.entities.dto;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Length;
import ru.darksavant.omegacrmservice.common.entities.Warehouse;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class WarehouseDTO {

    private String description;

    public WarehouseDTO(Warehouse warehouse) {
        this.description=warehouse.getDescription();
    }
}
