package ru.darksavant.omegacrmservice.common.entities.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Schema(description = "Запрос на получение токена")
@NoArgsConstructor
public class JwtRequest {
    @Schema(description = "Имя пользователя", required = true)
    private String username;

    @Schema(description = "Пользовательский пароль", required = true)
    private String password;
}
