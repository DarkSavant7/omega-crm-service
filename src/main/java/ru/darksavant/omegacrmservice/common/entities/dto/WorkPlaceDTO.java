
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
public class WorkPlaceDTO {

    private String title;

    public WorkPlaceDTO(WorkPlace workPlace) {
        this.title=workPlace.getTitle();
    }
}
