package ru.darksavant.omegacrmservice.common.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.*;
import org.hibernate.validator.constraints.Length;
import ru.darksavant.omegacrmservice.common.enums.UserStatus;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "contacts")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "FIO must NOT be empty")
    @NotEmpty(message = "FIO must NOT be empty")
    @NotNull(message = "FIO must NOT be empty")
    @Column(name = "FIO", unique = true)
    private String FIO;

    @NotBlank(message = "Position must NOT be empty")
    @NotEmpty(message = "Position must NOT be empty")
    @Length(message = "Position must be not more 50 digits", max = 50)
    @NotNull(message = "Position must NOT be empty")
    @Column(name = "position")
    private String position;

    @NotNull(message = "Phone must NOT be empty")
    @Column(name = "primary_phone ", unique = true)
    private int primaryPhone;

    @Column(name = "mobile_phone")
    private int mobilePhone;

    @Column(name = "work_phone")
    private int workPhone;

    @Column(name = "primary_email")
    @NotNull(message = "Email must NOT be empty")
    private String primaryEmail;

    @Column(name = "secondary_email")
    private String secondaryEmail;


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
        Contact user = (Contact) o;

        return Objects.equals(id, user.id);
    }

}
