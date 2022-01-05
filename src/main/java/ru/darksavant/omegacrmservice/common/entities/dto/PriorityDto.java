
package ru.darksavant.omegacrmservice.common.entities.dto;

import lombok.*;
import ru.darksavant.omegacrmservice.common.entities.Priority;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class PriorityDto {

    private String description;

    public PriorityDto(Priority priority) {
        this.description=priority.getDescription();
    }
}
