package ru.darksavant.omegacrmservice.common.entities.dto;

import lombok.*;
import ru.darksavant.omegacrmservice.common.entities.PaymentType;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class PaymentTypeDto {

    private String description;

    private String createdAt;

    private String updatedAt;

    public PaymentTypeDto(PaymentType paymentType) {
        this.description=paymentType.getDescription();
        this.createdAt=paymentType.getCreatedAt().toString();
        this.updatedAt=paymentType.getUpdatedAt().toString();
    }
}
