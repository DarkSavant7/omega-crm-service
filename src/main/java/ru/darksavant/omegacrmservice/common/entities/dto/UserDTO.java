package ru.darksavant.omegacrmservice.common.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.darksavant.omegacrmservice.common.entities.User;
import ru.darksavant.omegacrmservice.common.enums.UserStatus;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class UserDTO {

    private String username;

    private String email;

    private UserStatus status;

    private List<RoleDTO> roles;

    public UserDTO(User user) {
        this.username=user.getUsername();
        this.email=user.getEmail();
        this.status=user.getStatus();
        this.roles=user.getRoles().stream().map(RoleDTO::new).collect(Collectors.toList());
    }
}
