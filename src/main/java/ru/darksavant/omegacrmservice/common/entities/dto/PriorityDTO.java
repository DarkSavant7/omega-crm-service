
package ru.darksavant.omegacrmservice.common.entities.dto;

import lombok.*;
import ru.darksavant.omegacrmservice.common.entities.Priority;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class PriorityDTO {

    private String description;

    public PriorityDTO(Priority priority) {
        this.description=priority.getDescription();
    }
}
