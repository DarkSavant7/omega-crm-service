package ru.darksavant.omegacrmservice.common.controllers.interfaces;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.darksavant.omegacrmservice.common.entities.dto.RegisterUserDto;
import ru.darksavant.omegacrmservice.common.entities.dto.UserDto;

@Tag(name = "Контроллер для администратора системы")
@CrossOrigin("*")
@RequestMapping("/api/v1/admin")
public interface AdminController {

    @PostMapping("/registration")
    @Operation(summary = "Зарегистрировать нового пользователя, с указанием роли")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Пользователь успешно создан в системе",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserDto.class))})})
    ResponseEntity<UserDto> createUser(@Parameter(description = "DTO для создания нового пользователя") @RequestBody RegisterUserDto dto);
}
