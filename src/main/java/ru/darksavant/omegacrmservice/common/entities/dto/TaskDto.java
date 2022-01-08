package ru.darksavant.omegacrmservice.common.entities.dto;

import lombok.*;
import ru.darksavant.omegacrmservice.common.entities.Task;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class TaskDto {

    private String description;

    private String context;

    private UserDto producer;

    private UserDto executor;

    private String start;

    private String end;

    private PriorityDto priority;

    private TaskStatusDto status;

    private String createdAt;

    private String updatedAt;

    public TaskDto(Task task) {
        this.description = task.getDescription();
        this.context = task.getContext();
        this.producer = new UserDto(task.getProducer());
        this.executor = new UserDto(task.getExecutor());
        this.start = task.getStart().toString();
        this.end = task.getEnd().toString();
        this.priority = new PriorityDto(task.getPriority());
        this.status = new TaskStatusDto(task.getStatus());
        this.createdAt=task.getCreatedAt().toString();
        this.updatedAt=task.getUpdatedAt().toString();
    }
}
