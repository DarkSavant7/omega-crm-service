package ru.darksavant.omegacrmservice.common.entities.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.lang.Nullable;
import ru.darksavant.omegacrmservice.common.entities.Good;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Schema(description = "DTO описания товара")
public class GoodDto {

    @Schema(description = "ID товара")
    private Long id;

    @Schema(description = "Артикул товара")
    @Nullable
    private String vendorCode;

    @Schema(description = "Название товара")
    @Nullable
    private String title;

    @Schema(description = "Цена товара")
    @Nullable
    private BigDecimal price;

    @Schema(description = "Ссылка на общую фотографию товара")
    @Nullable
    private String urlPreview;

    @Schema(description = "Ссылка на превью товара")
    @Nullable
    private String urlFull;

    @Schema(description = "Описание товара")
    @Nullable
    private String description;

    @Schema(description = "Категории товара")
    @Nullable
    private List<CategoryDto> categories;

    @Schema(description = "Поставщики товара")
    @Nullable
    private List<ProducerDto> producers;

    @Schema(description = "Склады товара")
    @Nullable
    private List<WarehouseDto> warehouses;


    public GoodDto(Good good) {
        this.id = good.getId();
        this.vendorCode=good.getVendorCode();
        this.title=good.getTitle();
        this.price=good.getPrice();
        this.urlPreview=good.getUrlPreview();
        this.urlFull=good.getUrlFull();
        this.description=good.getDescription();
        this.categories=good.getCategories().stream().map(CategoryDto::new).collect(Collectors.toList());
        this.producers=good.getProducers().stream().map(ProducerDto::new).collect(Collectors.toList());
        this.warehouses=good.getWarehouses().stream().map(WarehouseDto::new).collect(Collectors.toList());
    }
}
