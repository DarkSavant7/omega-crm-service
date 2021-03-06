package ru.darksavant.omegacrmservice.common.services.implementation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.darksavant.omegacrmservice.common.entities.Category;
import ru.darksavant.omegacrmservice.common.repositories.CategoryRepository;
import ru.darksavant.omegacrmservice.common.services.interfaces.GoodsCategoryService;
import ru.darksavant.omegacrmservice.errors.ResourceNotFoundException;

@Service
@AllArgsConstructor
public class GoodsCategoryServiceImpl implements GoodsCategoryService {
    private final CategoryRepository categoryRepository;

    public Category findByName(String name) {
        return categoryRepository.findByName(name).orElseThrow(() -> new ResourceNotFoundException("Category not found"));
    }

    public Category save(Category d) {
        return categoryRepository.save(d);
    }

    public void delete(Category d) {
        categoryRepository.delete(d);
    }

    public void deleteById(Long id){
        categoryRepository.deleteById(id);
    }


}
