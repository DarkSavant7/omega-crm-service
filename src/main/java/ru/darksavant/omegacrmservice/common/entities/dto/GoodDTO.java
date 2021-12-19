package ru.darksavant.omegacrmservice.common.entities.dto;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.*;
import ru.darksavant.omegacrmservice.common.entities.Good;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class GoodDTO {

    private int vendorCode;

    private String title;

    private BigDecimal price;

    private String urlPreview;

    private String urlFull;

    private String description;

    private List<CategoryDTO> categories;

    private List<ProducerDTO> producers;

    private List<WarehouseDTO> warehouses;


    public GoodDTO(Good good) {
        this.vendorCode=good.getVendorCode();
        this.title=good.getTitle();
        this.price=good.getPrice();
        this.urlPreview=good.getUrlPreview();
        this.urlFull=good.getUrlFull();
        this.description=good.getDescription();
        this.categories=good.getCategories().stream().map(CategoryDTO::new).collect(Collectors.toList());
        this.producers=good.getProducers().stream().map(ProducerDTO::new).collect(Collectors.toList());
        this.warehouses=good.getWarehouses().stream().map(WarehouseDTO::new).collect(Collectors.toList());
    }
}
