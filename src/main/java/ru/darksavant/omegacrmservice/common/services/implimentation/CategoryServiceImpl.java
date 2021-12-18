package ru.darksavant.omegacrmservice.common.services.implimentation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.darksavant.omegacrmservice.common.entities.Category;
import ru.darksavant.omegacrmservice.common.repositories.CategoryRepository;
import ru.darksavant.omegacrmservice.common.services.interfaces.CategoryService;
import ru.darksavant.omegacrmservice.errors.ResourceNotFoundException;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository repository;

    public Category findById(Long id){
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category not found"));
    }

    public Category findByName(String name) {
        return repository.findByName(name).orElseThrow(() -> new ResourceNotFoundException("Category not found"));
    }

    public Category save(Category cat) {
        return repository.save(cat);
    }

    public void delete(Category cat) {
        repository.delete(cat);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }


}
