package ru.darksavant.omegacrmservice.common.controllers.interfaces;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import ru.darksavant.omegacrmservice.common.entities.dto.JwtRequest;
import ru.darksavant.omegacrmservice.common.entities.dto.JwtResponse;
import ru.darksavant.omegacrmservice.common.entities.dto.UserDTO;


@Tag(name = "Контроллер для авторизации")
@CrossOrigin("*")
@RequestMapping("/api/v1/auth")
public interface AuthController {

    @PostMapping("/login")
    @Operation(summary = "Получение токена авторизации")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Создан токен авторизации",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = JwtResponse.class))})})
    ResponseEntity<JwtResponse> createToken(@Parameter(description = "Имя пользователя и пароль") @RequestBody JwtRequest jwtRequest);


    @PostMapping("/registration")
    @Operation(summary = "Зарегистрировать нового пользователя, с указанием роли")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Пользователь успешно создан в системе",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserDTO.class))})})
    @Secured("ROLE_ADMIN")
    ResponseEntity<UserDTO> createUser(@Parameter(description = "Имя нового пользователя") @RequestParam(name = "userName") String userName,
                                       @Parameter(description = "Пароль нового пользователя") @RequestParam(name="password") String password,
                                       @Parameter(description = "Роль нового пользователя, в формате ROLE_****") @RequestParam(name="role") String role);



}
