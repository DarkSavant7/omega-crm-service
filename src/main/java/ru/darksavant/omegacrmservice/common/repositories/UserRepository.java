package ru.darksavant.omegacrmservice.common.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.darksavant.omegacrmservice.common.entities.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    Optional<User> findOneByEmail(String email);

    boolean existsByEmail(String email);
}
