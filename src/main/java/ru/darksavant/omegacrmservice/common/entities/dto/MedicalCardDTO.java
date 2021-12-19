package ru.darksavant.omegacrmservice.common.entities.dto;

import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import ru.darksavant.omegacrmservice.common.entities.MedicalCard;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class MedicalCardDTO {

    private String description;

    public MedicalCardDTO(MedicalCard card) {
        this.description=card.getDescription();
    }
}
