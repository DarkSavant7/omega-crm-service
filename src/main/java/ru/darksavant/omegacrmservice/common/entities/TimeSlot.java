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
@Table(name = "time_slots")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class TimeSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_time_slot")
    private Long id;

    @NotBlank(message = "Start time must NOT be empty")
    @Column(name = "started_at")
    private LocalDateTime start;

    @NotBlank(message = "End time must NOT be empty")
    @Column(name = "finished_at")
    private LocalDateTime end;

    @OneToOne
    @NotBlank(message = "Job must NOT be empty")
    @JoinColumn(name = "job_id")
    private Job job;

    @OneToOne
    @NotBlank(message = "Time slot status must NOT be empty")
    @JoinColumn(name = "status_id")
    private Status status;

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
        TimeSlot user = (TimeSlot) o;

        return Objects.equals(id, user.id);
    }

}
