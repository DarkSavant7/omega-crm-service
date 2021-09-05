package ru.darksavant.omegacrmservice.common.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "tasks")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_task")
    private Long id;

    @NotBlank(message = "Description of task must NOT be empty")
    @Column(name = "description")
    private String description;

    @Column(name = "context")
    private String context;

    @OneToOne
    @NotBlank(message = "Producer of task must NOT be empty")
    @JoinColumn(name = "producer")
    private User producer;

    @OneToOne
    @NotBlank(message = "Executor of task must NOT be empty")
    @JoinColumn(name = "executor")
    private User executor;

    @Column(name = "started_at")
    private LocalDateTime start;

    @Column(name = "finished_at")
    private LocalDateTime end;

    @OneToOne
    @JoinColumn(name = "priority_id")
    private Priority priority;

    @OneToOne
    @JoinColumn(name = "status_id")
    private TaskStatus status;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Task user = (Task) o;

        return Objects.equals(id, user.id);
    }

}
