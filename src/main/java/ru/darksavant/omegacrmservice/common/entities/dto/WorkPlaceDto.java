
package ru.darksavant.omegacrmservice.common.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.darksavant.omegacrmservice.common.entities.WorkPlace;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class WorkPlaceDto {

    private String title;

    public WorkPlaceDto(WorkPlace workPlace) {
        this.title=workPlace.getTitle();
    }
}
