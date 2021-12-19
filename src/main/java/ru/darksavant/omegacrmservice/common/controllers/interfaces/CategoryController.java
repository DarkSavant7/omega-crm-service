package ru.darksavant.omegacrmservice.common.controllers.interfaces;

import ru.darksavant.omegacrmservice.common.entities.Category;


public interface CategoryController {

    Category findById(Long id);

    Category findByName(String name);

    Category save(Category cat);

    void delete(Category cat);

    void deleteById(Long id);


}
