
package ru.darksavant.omegacrmservice.common.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.darksavant.omegacrmservice.common.entities.TaskStatus;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class TaskStatusDTO {

    private String description;


    public TaskStatusDTO(TaskStatus status) {
        this.description = status.getDescription();
    }
}
