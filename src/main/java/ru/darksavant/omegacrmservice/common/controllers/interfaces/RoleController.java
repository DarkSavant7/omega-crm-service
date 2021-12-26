package ru.darksavant.omegacrmservice.common.controllers.interfaces;

import ru.darksavant.omegacrmservice.common.entities.Role;

public interface RoleController {

    Role findById(Long id);

    Role findByName(String name);

    Role save(Role d);

    void delete(Role d);

    void deleteById(Long id);


}
