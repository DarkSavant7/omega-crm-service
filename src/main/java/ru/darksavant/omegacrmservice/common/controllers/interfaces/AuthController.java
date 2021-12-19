package ru.darksavant.omegacrmservice.common.controllers.interfaces;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.darksavant.omegacrmservice.common.entities.dto.JwtRequest;
import ru.darksavant.omegacrmservice.common.entities.dto.JwtResponse;


public interface AuthController {
    @PostMapping()
    @Operation(summary =  "Creates token for user.")
    ResponseEntity<JwtResponse> createToken(@RequestBody JwtRequest jwtRequest);

}
