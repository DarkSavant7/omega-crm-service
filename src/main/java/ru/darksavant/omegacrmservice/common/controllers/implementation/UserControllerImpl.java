package ru.darksavant.omegacrmservice.common.controllers.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.darksavant.omegacrmservice.common.controllers.interfaces.UserController;
import ru.darksavant.omegacrmservice.common.entities.dto.UserDto;
import ru.darksavant.omegacrmservice.common.enums.UserStatus;
import ru.darksavant.omegacrmservice.common.repositories.specifications.UserSpecification;
import ru.darksavant.omegacrmservice.common.services.interfaces.UserService;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserControllerImpl implements UserController {
    private final UserService userService;


    @Override
    public ResponseEntity<UserDto> changePassword(Principal principal, String oldPassword, String newPassword) {
        return ResponseEntity.ok(userService.changePassword(principal.getName(), oldPassword, newPassword));
    }

    @Override
    public ResponseEntity<Page<UserDto>> findUser(Integer page, Integer pageSize, String userName, String email, Long id) {
        if (page < 1) {
            page = 1;
        }
        return ResponseEntity.ok(userService.findAll(UserSpecification.build(userName, email, id), page, pageSize));
    }

    @Override
    public ResponseEntity<UserDto> update(String username, UserStatus status, String role) {
        return null;
    }
}
