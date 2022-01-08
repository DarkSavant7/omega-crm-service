package ru.darksavant.omegacrmservice.common.entities.dto;

import lombok.*;
import ru.darksavant.omegacrmservice.common.entities.MedicalCard;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class MedicalCardDto {

    private String description;

    public MedicalCardDto(MedicalCard card) {
        this.description=card.getDescription();
    }
}
