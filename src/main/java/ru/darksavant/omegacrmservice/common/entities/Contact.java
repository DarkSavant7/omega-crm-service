package ru.darksavant.omegacrmservice.common.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
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
    @Column(name = "FIO", unique = true)
    private String FIO;

    @NotBlank(message = "Position must NOT be empty")
    @Length(message = "Position must be not more 50 digits", max = 50)
    @Column(name = "position")
    private String position;

    @Column(name = "primary_phone", unique = true)
    private Integer primaryPhone;

    @Column(name = "mobile_phone")
    private Integer mobilePhone;

    @Column(name = "work_phone")
    private Integer workPhone;

    @Column(name = "primary_email")
    @NotNull(message = "Email must NOT be empty")
    @Email(message = "Поле должно быть email")
    private String primaryEmail;

    @Column(name = "secondary_email")
    @Email(message = "Поле должно быть email")
    private String secondaryEmail;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToOne
    @JoinColumn(name = "medical")
    private MedicalCard medicalCard;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Contact user = (Contact) o;

        return Objects.equals(id, user.id);
    }

}
