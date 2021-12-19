package ru.darksavant.omegacrmservice.common.services.implimentation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.darksavant.omegacrmservice.common.entities.Role;
import ru.darksavant.omegacrmservice.common.repositories.RoleRepository;
import ru.darksavant.omegacrmservice.common.services.interfaces.RoleService;
import ru.darksavant.omegacrmservice.errors.ResourceNotFoundException;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository repository;

    public Role findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Role not found"));
    }

    public Role findByName(String name) {
        return repository.findByName(name).orElseThrow(() -> new ResourceNotFoundException("Role not found"));
    }

    public Role save(Role d) {
        return repository.save(d);
    }

    public void delete(Role d) {
        repository.delete(d);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }


}
