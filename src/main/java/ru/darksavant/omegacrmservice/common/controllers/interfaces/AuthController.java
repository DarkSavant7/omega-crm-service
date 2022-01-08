package ru.darksavant.omegacrmservice.common.controllers.interfaces;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.darksavant.omegacrmservice.common.entities.dto.JwtRequest;
import ru.darksavant.omegacrmservice.common.entities.dto.JwtResponse;


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

}
