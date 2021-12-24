package ru.darksavant.omegacrmservice.common.services.interfaces;

import ru.darksavant.omegacrmservice.common.entities.Role;

import java.util.Optional;

public interface RoleService {

    Role findById(Long id);

    Optional<Role> findByName(String name);

    Role save(Role d);

    void delete(Role d);

    void deleteById(Long id);


}
