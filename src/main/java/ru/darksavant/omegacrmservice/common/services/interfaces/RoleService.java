package ru.darksavant.omegacrmservice.common.services.interfaces;

import ru.darksavant.omegacrmservice.common.entities.Role;

public interface RoleService {

    Role findById(Long id);

    Role findByName(String name);

    Role save(Role d);

    void delete(Role d);

    void deleteById(Long id);


}
