
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
public class TaskStatusDto {

    private String description;


    public TaskStatusDto(TaskStatus status) {
        this.description = status.getDescription();
    }
}
