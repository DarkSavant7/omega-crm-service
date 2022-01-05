package ru.darksavant.omegacrmservice.common.services.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import ru.darksavant.omegacrmservice.common.entities.User;
import ru.darksavant.omegacrmservice.common.entities.dto.RegisterUserDto;
import ru.darksavant.omegacrmservice.common.entities.dto.UserDto;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface UserService {
    ResponseEntity<UserDto> createUser(RegisterUserDto dto);

    User blockUser(Long userId);

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    Optional<User> findById(Long id);

    boolean existsByEmail(String email);

    User save(User user);

    List<User> findAllByIds(Collection<Long> ids);

    Page<UserDto> findAll(Specification<User> build, Integer page, Integer pageSize);

    UserDto changePassword(String name, String oldPassword, String newPassword);
}
