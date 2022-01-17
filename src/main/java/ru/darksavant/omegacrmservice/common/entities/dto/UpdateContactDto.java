package ru.darksavant.omegacrmservice.common.entities.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.lang.Nullable;


@Getter
@Setter
@ToString
@AllArgsConstructor
@Schema(description = "DTO обновления контакта")
public class UpdateContactDto {
    @Schema(description = "ID контакта")
    private Long id;

    @Schema(description = "ФИО")
    @Nullable
    private String FIO;

    @Schema(description = "Должность")
    @Nullable
    private String position;

    @Schema(description = "Основной телефон")
    @Nullable
    private Integer primaryPhone;

    @Schema(description = "Дополнительный телефон")
    @Nullable
    private Integer mobilePhone;

    @Schema(description = "Рабочий телефон")
    @Nullable
    private Integer workPhone;

    @Schema(description = "Основной email")
    @Nullable
    private String primaryEmail;

    @Schema(description = "Дополнительный email")
    @Nullable
    private String secondaryEmail;

}
