package ru.darksavant.omegacrmservice.common.entities.dto;

import lombok.*;
import ru.darksavant.omegacrmservice.common.entities.Role;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class RoleDto {

    private String name;

    public RoleDto(Role role) {
        this.name=role.getName();
    }
}
