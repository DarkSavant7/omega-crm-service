package ru.darksavant.omegacrmservice.common.controllers.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.darksavant.omegacrmservice.common.controllers.interfaces.AdminController;
import ru.darksavant.omegacrmservice.common.entities.dto.UserDTO;
import ru.darksavant.omegacrmservice.common.services.interfaces.UserService;

@RestController
@RequiredArgsConstructor
@Slf4j
public class AdminControllerImpl implements AdminController {
    private final UserService userService;

    @Override
    public ResponseEntity<UserDTO> createUser(String userName, String password, String role) {
      return userService.createUser(userName,password,role);
    }
}
