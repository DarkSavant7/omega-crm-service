package ru.darksavant.omegacrmservice.common.entities.dto;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;
import ru.darksavant.omegacrmservice.common.entities.PaymentType;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class PaymentTypeDTO {

    private String description;

    private String createdAt;

    private String updatedAt;

    public PaymentTypeDTO(PaymentType paymentType) {
        this.description=paymentType.getDescription();
        this.createdAt=paymentType.getCreatedAt().toString();
        this.updatedAt=paymentType.getUpdatedAt().toString();
    }
}
