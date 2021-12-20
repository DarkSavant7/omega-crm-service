package ru.darksavant.omegacrmservice.common.entities.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Schema(description = "THis is your request to log in")
@NoArgsConstructor
public class JwtRequest {
    @Schema(description = "Имя пользователя", required = true)
    private String username;

    @Schema(description = "Users password ", required = true)
    private String password;
}
