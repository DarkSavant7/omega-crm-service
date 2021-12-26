package ru.darksavant.omegacrmservice.common.controllers.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.darksavant.omegacrmservice.common.controllers.interfaces.UserController;
import ru.darksavant.omegacrmservice.common.entities.dto.UserDTO;
import ru.darksavant.omegacrmservice.common.repositories.specifications.UserSpecification;
import ru.darksavant.omegacrmservice.common.services.interfaces.UserService;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserControllerImpl implements UserController {
    private final UserService userService;


    @Override
    public ResponseEntity<UserDTO> changePassword(Principal principal, String oldPassword, String newPassword) {
        return null;
    }

    @Override
    public ResponseEntity<Page<UserDTO>> findUser(Integer page, Integer pageSize, String userName, String email, Long id) {
        if (page < 1) {
            page = 1;
        }
        return ResponseEntity.ok(userService.findAll(UserSpecification.build(userName, email, id), page, pageSize));
    }
}
