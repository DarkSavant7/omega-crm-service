package ru.darksavant.omegacrmservice.common.entities.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Schema(description = "DTO для создания пользователя")
public class RegisterUserDto {

    @NotBlank(message = "Имя пользователя не может быть пустым")
    @Schema(description = "Имя пользователя в системе, уникальное")
    @Length(message = "Длинна имени должна быть от 3 до 50 знаков", min = 3, max = 50)
    private String username;

    @NotBlank(message = "Email пользователя не может быть пустым")
    @Schema(description = "Email пользователя, уникальный")
    @Length(message = "Длинна email должна быть от 3 до 255 знаков", min = 3, max = 255)
    @Email(message = "Не подходит под валидацию email")
    private String email;

    @NotBlank(message = "Username must NOT be empty")
    @Schema(description = "Пароль пользователя при создании")
    @Length(message = "Длинна пароля должна быть от 3 до 80 знаков", min = 3, max = 80)
    private String password;

    @Schema(description = "Роль нового пользователя, в формате ROLE_****")
    @Length(message = "Длинна поля роли должна быть от 6 до 50 знаков", min = 6, max = 50)
    private String role;
}
