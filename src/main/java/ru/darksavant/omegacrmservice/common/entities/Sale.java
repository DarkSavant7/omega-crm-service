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
@Table(name = "sales")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sale")
    private Long id;

    @Column(name = "sale_date")
    private LocalDateTime saleDate;

    @Column(name = "total_amount")
    @NotBlank(message = "Total amount must NOT be empty")
    private BigDecimal totalAmount;

    @OneToOne
    @JoinColumn(name = "discount_id")
    private Discount discount;

    @OneToOne
    @JoinColumn(name = "payment_type_id")
    private PaymentType type;

    @OneToOne
    @JoinColumn(name = "status")
    private SaleStatus status;

    @NotBlank(message = "Saler must NOT be empty")
    @OneToOne
    @JoinColumn(name = "saler")
    private User saler;

    @NotBlank(message = "Title must NOT be empty")
    @OneToOne
    @JoinColumn(name = "buyer")
    private Contact buyer;


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
        Sale user = (Sale) o;

        return Objects.equals(id, user.id);
    }

}
