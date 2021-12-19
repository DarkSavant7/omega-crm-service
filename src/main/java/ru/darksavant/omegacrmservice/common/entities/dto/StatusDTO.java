
package ru.darksavant.omegacrmservice.common.entities.dto;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.validator.constraints.Length;
import ru.darksavant.omegacrmservice.common.entities.Status;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;


@Getter
@Setter
@ToString
@AllArgsConstructor
public class StatusDTO {

    private String title;

    public StatusDTO(Status status) {
        this.title=status.getTitle();
    }
}
