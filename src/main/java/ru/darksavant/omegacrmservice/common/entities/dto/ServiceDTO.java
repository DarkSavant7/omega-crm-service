package ru.darksavant.omegacrmservice.common.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.darksavant.omegacrmservice.common.entities.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class ServiceDTO {

    private String description;

    private String title;

    private BigDecimal price;

    private List<ServiceCategoryDTO> category;

    public ServiceDTO(Service service) {
        this.description=service.getDescription();
        this.title=service.getTitle();
        this.price=service.getPrice();
        this.category=service.getCategory().stream().map(ServiceCategoryDTO::new).collect(Collectors.toList());
    }
}
