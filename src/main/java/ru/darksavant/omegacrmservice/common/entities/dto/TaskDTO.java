package ru.darksavant.omegacrmservice.common.entities.dto;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import ru.darksavant.omegacrmservice.common.entities.Task;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class TaskDTO {

    private String description;

    private String context;

    private UserDTO producer;

    private UserDTO executor;

    private String start;

    private String end;

    private PriorityDTO priority;

    private TaskStatusDTO status;

    private String createdAt;

    private String updatedAt;

    public TaskDTO(Task task) {
        this.description = task.getDescription();
        this.context = task.getContext();
        this.producer = new UserDTO(task.getProducer());
        this.executor = new UserDTO(task.getExecutor());
        this.start = task.getStart().toString();
        this.end = task.getEnd().toString();
        this.priority = new PriorityDTO(task.getPriority());
        this.status = new TaskStatusDTO(task.getStatus());
        this.createdAt=task.getCreatedAt().toString();
        this.updatedAt=task.getUpdatedAt().toString();
    }
}
