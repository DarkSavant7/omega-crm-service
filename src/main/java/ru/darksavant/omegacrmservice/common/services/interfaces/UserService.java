package ru.darksavant.omegacrmservice.common.services.interfaces;

import ru.darksavant.omegacrmservice.common.entities.User;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface UserService {

    User blockUser(Long userId);

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    Optional<User> findById(Long id);

    boolean existsByEmail(String email);

    User save(User user);

    List<User> findAllByIds(Collection<Long> ids);
}
