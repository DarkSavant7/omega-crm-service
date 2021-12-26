package ru.darksavant.omegacrmservice.common.controllers.interfaces;

import ru.darksavant.omegacrmservice.common.entities.Category;


public interface GoodsCategoryController {

    Category findByName(String name);

    Category save(Category d);

    void delete(Category d);

    void deleteById(Long id);

}
