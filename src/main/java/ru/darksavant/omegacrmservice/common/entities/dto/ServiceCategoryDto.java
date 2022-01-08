
package ru.darksavant.omegacrmservice.common.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.darksavant.omegacrmservice.common.entities.ServiceCategory;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class ServiceCategoryDto {

    private String name;

    public ServiceCategoryDto(ServiceCategory serviceCategory) {
        this.name=serviceCategory.getName();
    }
}
