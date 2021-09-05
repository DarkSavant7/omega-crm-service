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

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "services")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_service")
    private Long id;

    @Column(name = "description")
    private String description;

    @NotBlank(message = "Service title must NOT be empty")
    @Length(message = "Service title must be not more 50 digits", max = 50)
    @Column(name = "title", unique = true)
    private String title;

    @Column(name = "price")
    private BigDecimal price;

    @ManyToMany
    @JoinTable(name = "service_category_service",
            joinColumns = @JoinColumn(name = "service_category"),
            inverseJoinColumns = @JoinColumn(name = "category_service"))
    @ToString.Exclude
    private List<ServiceCategory> category;


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
        Service user = (Service) o;

        return Objects.equals(id, user.id);
    }

}
