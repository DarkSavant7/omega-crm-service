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
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "goods")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Good {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "Vendor code must NOT be empty")
    @NotNull(message = "Vendor code must NOT be empty")
    @NotEmpty(message = "Vendor code must NOT be empty")
    @Column(name = "vendor_code", unique = true)
    private String vendorCode;

    @NotBlank(message = "Title must NOT be empty")
    @NotNull(message = "Title must NOT be empty")
    @NotEmpty(message = "Title must NOT be empty")
    @Column(name = "vendor_code")
    private String title;

    @NotBlank(message = "Price must NOT be empty")
    @NotNull(message = "Price must NOT be empty")
    @NotEmpty(message = "Price must NOT be empty")
    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "url_preview")
    private String urlPreview;

    @Column(name="url_full")
    private String urlFull;

    @Column(name="description")
    private String description;

    @ManyToMany
    @JoinTable(name = "goods_category",
            joinColumns = @JoinColumn(name = "goods_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id "))
    @ToString.Exclude
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Category> categories;

    @ManyToMany
    @JoinTable(name = "good_producer",
            joinColumns = @JoinColumn(name = "goods_id"),
            inverseJoinColumns = @JoinColumn(name = "producer_id "))
    @ToString.Exclude
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Producer> producers;

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
        Good user = (Good) o;

        return Objects.equals(id, user.id);
    }

}
