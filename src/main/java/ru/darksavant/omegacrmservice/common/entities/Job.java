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
@Table(name = "jobs")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_job")
    private Long id;

    @OneToOne
    @NotBlank(message = "Service must NOT be empty")
    @JoinColumn(name = "service_id")
    private Service service;

    @OneToOne
    @NotBlank(message = "User must NOT be empty")
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @NotBlank(message = "Contact must NOT be empty")
    @JoinColumn(name = "contact_id")
    private Contact contact;

    @OneToOne
    @NotBlank(message = "Work place must NOT be empty")
    @JoinColumn(name = "work_place_id")
    private WorkPlace workPlace;

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
        Job user = (Job) o;

        return Objects.equals(id, user.id);
    }

}
