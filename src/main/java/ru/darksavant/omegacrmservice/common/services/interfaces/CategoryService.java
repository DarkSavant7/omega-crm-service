package ru.darksavant.omegacrmservice.common.services.interfaces;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.darksavant.omegacrmservice.common.entities.Category;
import ru.darksavant.omegacrmservice.common.repositories.CategoryRepository;
import ru.darksavant.omegacrmservice.errors.ResourceNotFoundException;


public interface CategoryService {

    Category findById(Long id);

    Category findByName(String name);

    Category save(Category cat);

    void delete(Category cat);

    void deleteById(Long id);


}
