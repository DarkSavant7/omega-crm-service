package ru.darksavant.omegacrmservice.common.controllers.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.darksavant.omegacrmservice.beans.JwtTokenUtil;
import ru.darksavant.omegacrmservice.common.controllers.interfaces.AuthController;
import ru.darksavant.omegacrmservice.common.entities.User;
import ru.darksavant.omegacrmservice.common.entities.dto.JwtRequest;
import ru.darksavant.omegacrmservice.common.entities.dto.JwtResponse;
import ru.darksavant.omegacrmservice.common.enums.UserStatus;
import ru.darksavant.omegacrmservice.common.services.interfaces.UserService;
import ru.darksavant.omegacrmservice.errors.BadRequestException;

@RestController
@RequiredArgsConstructor
@Slf4j
public class AuthControllerImpl implements AuthController {
    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtTokenUtil jwtTokenUtil;

    @Override
    public ResponseEntity<JwtResponse> createToken(@RequestBody JwtRequest jwtRequest) {
        log.info("User trying to log in with login: {}", jwtRequest.getUsername());
        User user = userService.findByUsername(jwtRequest.getUsername()).orElseThrow(() -> new UsernameNotFoundException("User not found!"));
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),
                jwtRequest.getPassword()));
        if (user.getStatus() == UserStatus.CREATED) {
            throw new BadRequestException("You must confirm your email or phone first");
        } else if (user.getStatus() == UserStatus.BLOCKED || user.getStatus() == UserStatus.DELETED) {
            throw new BadRequestException("BAN");
        }
        String token = jwtTokenUtil.generateTokenFromUser(user);
        log.info("Success logged user {} with roles: {}", user.getUsername(), user.getRoles());
        return ResponseEntity.ok(new JwtResponse(token));
    }

}
