package ru.darksavant.omegacrmservice.common.controllers.interfaces;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import ru.darksavant.omegacrmservice.common.entities.dto.UserDTO;

import java.security.Principal;

@Tag(name = "Контроллер для пользователей системы")
@CrossOrigin("*")
@RequestMapping("/api/v1/users")
public interface UserController {

    @PutMapping("/pass")
    @Operation(summary = "Сменить пользовательский пароль")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Смена пароля успешно проведена",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserDTO.class))})})
    ResponseEntity<UserDTO> changePassword(@Parameter(hidden = true) Principal principal,
                                           @Parameter(description = "Старый пароль") @RequestParam(name = "oldPassword") String oldPassword,
                                           @Parameter(description = "Новый пароль") @RequestParam(name = "newPassword") String newPassword);

    @GetMapping("/get_user")
    @Operation(summary = "Найти пользователя по имени")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Пользователь успешно найден в системе",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserDTO.class))})})
    ResponseEntity<Page<UserDTO>> findUser(@Parameter(hidden = true) @RequestParam(name = "page", defaultValue = "1") Integer page,
                                           @Parameter(hidden = true) @RequestParam(name = "page_size", defaultValue = "10") Integer pageSize,
                                           @Parameter(description = "Имя пользователя") @RequestParam(required = false, name = "name") @Nullable String userName,
                                           @Parameter(description = "Email пользователя") @RequestParam(required = false, name = "email") @Nullable String email,
                                           @Parameter(description = "Id пользователя") @RequestParam(required = false, name = "id") Long id);


}
