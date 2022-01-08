
package ru.darksavant.omegacrmservice.common.entities.dto;

import lombok.*;
import ru.darksavant.omegacrmservice.common.entities.Status;


@Getter
@Setter
@ToString
@AllArgsConstructor
public class StatusDto {

    private String title;

    public StatusDto(Status status) {
        this.title=status.getTitle();
    }
}
