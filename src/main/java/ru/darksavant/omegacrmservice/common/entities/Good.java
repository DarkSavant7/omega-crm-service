package ru.darksavant.omegacrmservice.common.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.*;

import javax.persistence.Entity;
import javax.persistence.Table;
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
@Table(name = "goods")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Good {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "Vendor code must NOT be empty")
    @Column(name = "vendor_code", unique = true)
    private int vendorCode;

    @NotBlank(message = "Title must NOT be empty")
    @Column(name = "title")
    private String title;

    @NotBlank(message = "Price must NOT be empty")
    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "url_preview")
    private String urlPreview;

    @Column(name="url_full")
    private String urlFull;

    @Column(name="description")
    private String description;

    @ManyToMany
    @JoinTable(name = "goods_category_cross",
            joinColumns = @JoinColumn(name = "goods_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    @ToString.Exclude
    private List<Category> categories;

    @ManyToMany
    @JoinTable(name = "good_producer_cross",
            joinColumns = @JoinColumn(name = "goods_id"),
            inverseJoinColumns = @JoinColumn(name = "producer_id"))
    @ToString.Exclude
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Producer> producers;

    @ManyToMany
    @JoinTable(name = "warehouses_goods",
            joinColumns = @JoinColumn(name = "good_id"),
            inverseJoinColumns = @JoinColumn(name = "warehouse_id"))
    @ToString.Exclude
    private List<Warehouse> warehouses;

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
